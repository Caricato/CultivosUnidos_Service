package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseEntryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaMerchandiseEntryRepository extends JpaRepository<MerchandiseEntryJpaEntity, Long> {
}
