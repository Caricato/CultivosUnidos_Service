package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleToRegisterDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate saleDate;
    List<SaleDetailToRegister> detail;
    Long communityId;
}
