package org.sistema.arroz.riceservice.modules.users.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserRole {
    SUPERVISOR("SUPERVISOR"), PRODUCER("PRODUCTOR AGRICOLA");

    @Getter
    private final String value;
}
