package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

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
@Table(name= "TS_PARAMETROS_GENERALES")
public class ParametersJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametros")
    private Long parametersId;

    @Column(name = "duracion_cronograma")
    private Integer durationSchedule;

    @OneToOne
    @JoinColumn(name = "id_comunidad")
    private AgricultureCommunityJpaEntity community;
}
