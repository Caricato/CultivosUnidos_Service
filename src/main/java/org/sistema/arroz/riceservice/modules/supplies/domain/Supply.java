package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Data;

@Data
public class Supply {
    String supplyName;
    Integer stock;
    Double unitPricing;
    Integer stockMin;
    Boolean state;
}