package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseEntryDetailJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaMerchandiseEntryDetailRepository extends JpaRepository<MerchandiseEntryDetailJpaEntity, Long> {
}
