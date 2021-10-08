package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaUserRepository extends JpaRepository<UserJpaEntity, Long> {
}
