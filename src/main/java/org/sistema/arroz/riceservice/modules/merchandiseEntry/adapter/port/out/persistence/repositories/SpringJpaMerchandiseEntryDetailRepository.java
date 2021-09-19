package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseFlowDetailJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaMerchandiseEntryDetailRepository extends JpaRepository<MerchandiseFlowDetailJpaEntity, Long> {
    Page<MerchandiseFlowDetailJpaEntity> findByMerchandiseFlow_MerchandiseFlowId(Pageable pageable, Long merchandiseEntryId);
}
