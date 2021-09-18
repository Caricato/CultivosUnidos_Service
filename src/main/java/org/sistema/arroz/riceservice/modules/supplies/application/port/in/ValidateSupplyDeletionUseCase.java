package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.List;

public interface ValidateSupplyDeletionUseCase {
    List<Product> validateSupplyDeletion(Long supplyId);
}
