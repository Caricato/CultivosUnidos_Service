package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class MerchandiseFlowInvalidException extends RuntimeException implements UserInputException {
    private final String code = "MER_02";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String subtype;
    }

    public MerchandiseFlowInvalidException(String subtype){
        super();
        this.message = String.format(ErrorMessages.MER_02_MESSAGE, subtype);
        this.data = subtype;
    }
}
