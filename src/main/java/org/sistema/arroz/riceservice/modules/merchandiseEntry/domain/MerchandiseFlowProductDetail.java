package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseFlowProductDetail {
    Long entryDetailId;
    MerchandiseFlow merchandiseFlow;
    Product product;
    Integer entryCant;
}
