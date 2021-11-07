package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SUP_06_MESSAGE;

@Getter
public class UnitMetricNotValidToDeleteException extends RuntimeException implements NotFoundException {
    private final String code = "SUP_06";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long unitMetricId;
    }

    public UnitMetricNotValidToDeleteException(Long unitMetricId){
        super();
        this.message = String.format(SUP_06_MESSAGE, unitMetricId);
        this.data = unitMetricId;
    }
}
