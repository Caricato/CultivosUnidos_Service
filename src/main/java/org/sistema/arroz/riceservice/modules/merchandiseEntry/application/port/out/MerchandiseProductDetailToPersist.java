package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseProductDetailToPersist {
    MerchandiseFlow merchandiseFlow;
    Product product;
    Integer entryCant;
}
