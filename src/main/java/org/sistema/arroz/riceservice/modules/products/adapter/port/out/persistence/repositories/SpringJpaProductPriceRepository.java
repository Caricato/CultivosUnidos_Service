package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.entities.ProductPriceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringJpaProductPriceRepository extends JpaRepository<ProductPriceJpaEntity, Long> {
    ProductPriceJpaEntity findByProduct_ProductIdAndMonth(Long productId, Integer month);
    List<ProductPriceJpaEntity> findByProduct_ProductId(Long productId);
    void deleteAllByProduct_ProductId(Long productId);
}
