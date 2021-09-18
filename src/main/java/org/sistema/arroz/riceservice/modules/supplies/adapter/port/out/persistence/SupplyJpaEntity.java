package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityJpaEntity;

import javax.persistence.*;

@ToString
@Getter @Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_INSUMO")
public class SupplyJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo")
    private Long supplyId;

    @Column(name = "nom_insumo", length = 100)
    private String supplyName;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "precio_unitario")
    private Double unitPricing;

    @Column(name = "stock_min")
    private Double stockMin;

    @Column(name = "tipo_metrica")
    private Integer supplyMetricType;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_comunidad")
    private AgricultureCommunityJpaEntity communityJpaEntity;
}