package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaUserRepository extends JpaRepository<UserJpaEntity, Long> {
    Optional<UserJpaEntity> findByUsernameAndState(String username, Boolean state);
}
