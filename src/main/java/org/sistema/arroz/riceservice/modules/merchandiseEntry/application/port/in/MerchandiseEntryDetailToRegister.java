package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseEntryDetailToRegister {
    Long supplyId;
    Double entryCant;
}
