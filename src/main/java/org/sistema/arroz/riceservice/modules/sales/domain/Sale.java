package org.sistema.arroz.riceservice.modules.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    Long saleId;
    LocalDateTime saleDate;
    Double saleTotal;
    Double theoreticalIndicator;
    Double realIndicator;
    AgricultureCommunity community;
}
