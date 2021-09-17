package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.ProductJpaEntity;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyJpaEntity;

import javax.persistence.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name= "TS_FORMULA_INSUMO")
public class SupplyFormulaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formula_insumo")
    private Long supplyFormulaId;

    @Column(name = "cant_x_hectarea")
    private Double cantForHectare;

    @ManyToOne
    @JoinColumn(name = "id_insumo")
    private SupplyJpaEntity supply;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductJpaEntity product;
}
