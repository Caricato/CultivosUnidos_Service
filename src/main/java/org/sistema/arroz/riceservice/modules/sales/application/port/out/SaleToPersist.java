package org.sistema.arroz.riceservice.modules.sales.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleToPersist {
    LocalDate saleDate;
    Double saleTotal;
    Double theoreticalTotal;
    Double theoreticalIndicator;
    Double realIndicator;
    AgricultureCommunity community;
}
