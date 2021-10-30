package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
