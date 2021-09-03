package org.sistema.arroz.riceservice.config;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class LocalDateTimePeruZone {

    private LocalDateTimePeruZone(){
        //to encapsulate the public constructor
    }

    public static LocalDateTime now(){
        return LocalDateTime.now(ZoneId.of("GMT-5"));
    }
}

