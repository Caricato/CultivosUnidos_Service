package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class GetBudgetDTO {
    List<GetSuppliesBudgetDTO> supplies;
    Double total;
}
