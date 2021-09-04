package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaProductRepository extends JpaRepository<ProductJpaEntity, Long> {
}
