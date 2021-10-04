package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityJpaEntity;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TP_VENTA")
public class SaleJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long saleId;

    @Column(name = "fecha_venta")
    private LocalDate saleDate;

    @Column(name = "ganancia_total")
    private Double saleTotal;

    @Column(name = "ganancia_teorica")
    private Double theoreticalTotal;

    @Column(name = "indicador_teorico")
    private Double theoreticalIndicator;

    @Column(name = "indicador_real")
    private Double realIndicator;

    @ManyToOne
    @JoinColumn(name = "id_comunidad")
    private AgricultureCommunityJpaEntity community;
}
