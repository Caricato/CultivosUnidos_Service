package org.sistema.arroz.riceservice.modules.producers.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.users.domain.User;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    Long producerId;
    String producerName;
    String producerFirstLastName;
    String producerSecondLastName;
    String dni;
    String email;
    String phone;
    String address;
    Double hectares;
    LocalDateTime inscriptionDate;
    LocalDateTime updateDate;
    User user;
    AgricultureCommunity community;

    public String fullName(){
        var fullName="";
        fullName+= producerFirstLastName;
        if (producerSecondLastName != null) fullName+=" "+producerSecondLastName;
        fullName+= ", "+producerName;
        return  fullName;
    }
}
