package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseEntryDetailJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaMerchandiseEntryDetailRepository extends JpaRepository<MerchandiseEntryDetailJpaEntity, Long> {
    Page<MerchandiseEntryDetailJpaEntity> findByMerchandiseEntry_MerchandiseEntryId(Pageable pageable, Long merchandiseEntryId);
}
