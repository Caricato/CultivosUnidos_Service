package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

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
@Table(name= "TP_PRODUCTO")
public class ProductJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long productId;

    @Column(name = "nom_producto", length = 100)
    private String productName;

    @Column(name = "stock")
    private Double stock;

    @Column(name = "hectareas_x_saco")
    private Double sacks;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_comunidad")
    private AgricultureCommunityJpaEntity communityJpaEntity;
}
