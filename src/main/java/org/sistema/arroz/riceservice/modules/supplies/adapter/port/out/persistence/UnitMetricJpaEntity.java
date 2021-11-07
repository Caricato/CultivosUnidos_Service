package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TS_UNIDAD_METRICA")
public class UnitMetricJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad_metrica")
    private Long unitMetricId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_comunidad")
    private AgricultureCommunityJpaEntity community;
}
