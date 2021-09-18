package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities;

import io.micrometer.core.lang.Nullable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.ProductJpaEntity;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TS_DETALLE_FLUJO")
public class MerchandiseFlowDetailJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_flujo")
    private Long flowDetailId;

    @Column(name = "cant_flow")
    private Integer flowCant;

    @OneToOne
    @JoinColumn(name = "id_insumo")
    @Nullable
    private SupplyJpaEntity supply;

    @OneToOne
    @JoinColumn(name = "id_producto")
    @Nullable
    private ProductJpaEntity product;

    @ManyToOne
    @JoinColumn(name = "id_entrada_mercancia")
    private MerchandiseFlowJpaEntity flowEntry;
}
