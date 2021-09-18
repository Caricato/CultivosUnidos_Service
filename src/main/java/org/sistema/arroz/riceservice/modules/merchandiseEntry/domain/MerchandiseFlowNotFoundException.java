package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

@Getter
public class MerchandiseFlowNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "MER_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long communityId;
    }

    public MerchandiseFlowNotFoundException(Long merchandiseEntryId){
        super();
        this.message = String.format(ErrorMessages.MER_01_MESSAGE, merchandiseEntryId);
        this.data = merchandiseEntryId;
    }
}
