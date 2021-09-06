package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TS_DETALLE_ENTRADA")
public class MerchandiseEntryDetailJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_entrada")
    private Long entryDetailId;

    @Column(name = "cant_entrada")
    private Integer entryCant;

    @OneToOne
    @JoinColumn(name = "id_insumo")
    private SupplyJpaEntity supply;

    @ManyToOne
    @JoinColumn(name = "id_entrada_mercancia")
    private MerchandiseEntryJpaEntity merchandiseEntry;
}
