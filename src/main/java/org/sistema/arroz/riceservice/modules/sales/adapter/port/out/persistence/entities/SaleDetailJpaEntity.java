package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.ProductJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TR_DETALLE_VENTA")
public class SaleDetailJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_venta")
    private Long saleDetailId;

    @Column(name = "sacos_vendidos")
    private Integer soldSacks;

    @Column(name = "subtotal")
    private Double subtotal;

    @OneToOne
    @JoinColumn(name = "id_venta")
    private SaleJpaEntity sale;

    @OneToOne
    @JoinColumn(name = "id_producto")
    private ProductJpaEntity product;
}
