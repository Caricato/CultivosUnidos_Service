package org.sistema.arroz.riceservice.modules.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    Long saleId;
    LocalDate saleDate;
    Double saleTotal;
    Double theoreticalTotal;
    Double theoreticalIndicator;
    Double realIndicator;
    AgricultureCommunity community;
}
