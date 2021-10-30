package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.entities.ProductJpaEntity;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_CRONOGRAMA")
public class ScheduleJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cronograma")
    private Long scheduleId;

    @Column(name = "fecha_inicio")
    private LocalDate startDate;

    @Column(name = "fecha_fin")
    private LocalDate endDate;

    @Column(name = "hectareas")
    private Double hectares;

    @Column(name = "estado")
    private Integer state;

    @JoinColumn(name = "id_producto")
    @ManyToOne
    private ProductJpaEntity product;
}
