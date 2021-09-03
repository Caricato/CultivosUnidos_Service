package org.sistema.arroz.riceservice.modules.agricultureCommunity.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

@Getter
public class AgricultureCommunityNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "AGC_01";
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

    public AgricultureCommunityNotFoundException(Long communityId){
        super();
        this.message = String.format("Agriculture community with %d id is not registered!", communityId);
        this.data = communityId;
    }
}
