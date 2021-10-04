package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetSaleDTO {
    SaleDTO sale;
    List<SaleDetailDTO> saleDetails;
}
