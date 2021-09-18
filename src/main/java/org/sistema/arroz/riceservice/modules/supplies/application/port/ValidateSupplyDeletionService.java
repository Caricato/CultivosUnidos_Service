package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.ValidateSupplyDeletionUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.ValidateSupplyDeletionPort;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ValidateSupplyDeletionService implements ValidateSupplyDeletionUseCase {
    private final ValidateSupplyDeletionPort validateSupplyDeletionPort;

    @Override
    public List<Product> validateSupplyDeletion(Long supplyId) {
        return validateSupplyDeletionPort.validateSupplyDeletion(supplyId);
    }
}
