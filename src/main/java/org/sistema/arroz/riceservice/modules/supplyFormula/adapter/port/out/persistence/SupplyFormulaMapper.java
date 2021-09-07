package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.ProductMapper;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMapper;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.SupplyFormulaToPersist;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SupplyMapper.class, ProductMapper.class})
public interface SupplyFormulaMapper {
    @Mapping(source = "supplyFormulaId", target = "supplyFormulaId")
    @Mapping(source = "cantForHectare", target = "cantForHectare")
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "product", target = "product")
    SupplyFormula toSupplyFormula(SupplyFormulaJpaEntity supplyJpaEntity);
    List<SupplyFormula> toSuppliesFormulas(List<SupplyFormulaJpaEntity> supplyFormulaJpaEntities);

    @Mapping(source = "cantForHectare", target = "cantForHectare")
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "product", target = "product")
    @Mapping(target = "supplyFormulaId", ignore = true)
    SupplyFormulaJpaEntity toSupplyFormulaJpa(SupplyFormulaToPersist supplyFormulaToPersist);
    List<SupplyFormulaJpaEntity> toSuppliesFormulasJpa(List<SupplyFormulaToPersist> supplyFormulaToPersist);
}
