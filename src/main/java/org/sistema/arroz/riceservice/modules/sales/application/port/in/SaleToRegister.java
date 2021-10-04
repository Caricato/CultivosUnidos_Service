package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleToRegister {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate saleDate;
}
