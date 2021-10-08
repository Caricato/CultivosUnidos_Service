package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.application.port.out.DeleteUserPort;
import org.sistema.arroz.riceservice.modules.users.application.port.out.RegisterUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.User;

import javax.transaction.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements DeleteUserPort, RegisterUserPort {
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
}
