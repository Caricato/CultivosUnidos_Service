package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.List;

public interface ValidateSupplyDeletionPort {
    List<Product> validateSupplyDeletion(Long supplyId);
}
