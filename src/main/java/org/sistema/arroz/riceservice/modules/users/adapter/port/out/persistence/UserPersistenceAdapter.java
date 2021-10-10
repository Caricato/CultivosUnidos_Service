package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.application.port.out.DeleteUserPort;
import org.sistema.arroz.riceservice.modules.users.application.port.out.GeneratePasswordPort;
import org.sistema.arroz.riceservice.modules.users.application.port.out.GetUserPort;
import org.sistema.arroz.riceservice.modules.users.application.port.out.RegisterUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.User;
import org.sistema.arroz.riceservice.modules.users.domain.UserNotFoundException;
import org.sistema.arroz.riceservice.modules.users.domain.UsernameNotFoundException;

import javax.transaction.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements DeleteUserPort, RegisterUserPort, GetUserPort, GeneratePasswordPort {
    private final UserMapper userMapper;
    private final SpringJpaUserRepository userRepository;

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User registerUser(UserToRegister userToRegister) {
        var user = userMapper.toUserJpa(userToRegister);
        user.setPasswordReset(false);
        user.setPasswordFirstTime(true);
        user.setState(true);
        var result = userRepository.save(user);
        return userMapper.toUser(result);
    }

    @Override
    public User getUser(Long userId) {
        var user = userRepository.findById(userId);
        if (user.isEmpty()) throw new UserNotFoundException(userId);
        return userMapper.toUser(user.get());
    }

    @Override
    public User getUser(String username) {
        var user = userRepository.findByUsernameAndState(username, true);
        if (user.isEmpty()) throw new UsernameNotFoundException(username);
        return userMapper.toUser(user.get());

    }

    @Override
    public void generatePassword(Long userId, String encryptedPassword) {
        var entityOptional = userRepository.findById(userId);
        if (entityOptional.isEmpty()) throw new UserNotFoundException(userId);
        var entity = entityOptional.get();
        entity.setPassword(encryptedPassword);
        entity.setPasswordFirstTime(false);
        userRepository.save(entity);
    }
}
