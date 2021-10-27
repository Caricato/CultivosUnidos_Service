package org.sistema.arroz.riceservice.hexagonal.sms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SMS {
    private String to;
    private String message;

    @Override
    public String toString(){
        return "SMS{"+"to= '"+to+'\''+", message='"+message+'\''+'}';
    }
}
