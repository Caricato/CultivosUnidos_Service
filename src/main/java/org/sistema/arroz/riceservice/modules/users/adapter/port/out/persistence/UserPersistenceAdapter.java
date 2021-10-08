package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter {
    private final UserMapper userMapper;
    private final SpringJpaUserRepository userRepository;
}
