package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMapper;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMetricTypeMapper;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetSuppliesFormulasMapper {
    @Mapping(source = "cantForHectare", target = "cantForHectare")
    @Mapping(source = "supplyFormulaId", target = "supplyFormulaId")
    @Mapping(target = "supplyId", ignore = true)
    @Mapping(target = "supplyName", ignore = true)
    @Mapping(target = "supplyMetricType", ignore = true)
    @Mapping(target = "productId", ignore = true)
    GetSuppliesFormulasDTO getSupplyFormulaDTO(SupplyFormula supplyFormulas);
    List<GetSuppliesFormulasDTO> getSuppliesFormulasDTO(List<SupplyFormula> supplyFormulas);

    @AfterMapping
    default void setSupplyFormula(SupplyFormula supplyFormula, @MappingTarget GetSuppliesFormulasDTO suppliesFormulasDTO){
        suppliesFormulasDTO.setSupplyId(supplyFormula.getSupply().getSupplyId());
        suppliesFormulasDTO.setSupplyName(supplyFormula.getSupply().getSupplyName());
        suppliesFormulasDTO.setSupplyMetricType(supplyFormula.getSupply().getSupplyMetricType());
        suppliesFormulasDTO.setProductId(supplyFormula.getProduct().getProductId());
    }
}
