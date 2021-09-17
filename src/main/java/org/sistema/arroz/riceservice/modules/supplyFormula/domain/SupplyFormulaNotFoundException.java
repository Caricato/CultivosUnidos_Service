package org.sistema.arroz.riceservice.modules.supplyFormula.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SUP_FORM_01_MESSAGE;

@Getter
public class SupplyFormulaNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "SUP_FORM_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long productId;
    }

    public SupplyFormulaNotFoundException(Long supplyFormulaId){
        super();
        this.message = String.format(SUP_FORM_01_MESSAGE, supplyFormulaId);
        this.data = supplyFormulaId;
    }
}
