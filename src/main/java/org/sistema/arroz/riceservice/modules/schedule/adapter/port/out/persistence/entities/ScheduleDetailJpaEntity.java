package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence.ProducerJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TR_DETALLE_CRONOGRAMA")
public class ScheduleDetailJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_cronograma")
    private Long scheduleDetailId;

    @Column(name = "cant_hectareas")
    private Double hectares;

    @Column(name = "hectareas_liberadas")
    private Boolean isFreeHectares;

    @ManyToOne
    @JoinColumn(name = "id_cronograma")
    private ScheduleJpaEntity schedule;

    @ManyToOne
    @JoinColumn(name = "id_productor_agricola")
    private ProducerJpaEntity producer;
}
