package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.entities;

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
@Table(name= "TS_PRODUCTO_PRECIO")
public class ProductPriceJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_precio")
    private Long productPriceId;

    @Column(name = "mes")
    private Integer month;

    @Column(name = "precio_unitario")
    private Double unitPricing;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductJpaEntity product;
}
