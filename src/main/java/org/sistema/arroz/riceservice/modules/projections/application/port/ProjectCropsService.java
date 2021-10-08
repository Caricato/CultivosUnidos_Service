package org.sistema.arroz.riceservice.modules.projections.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPricePort;
import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProductsToProject;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProjectCrops;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProjectCropsUseCase;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProjectionCropsDTO;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ProjectCropsService implements ProjectCropsUseCase {
    private final GetProductPricePort getProductPricePort;
    private final GetProductUseCase getProductUseCase;

    @Override
    public ProjectionCropsDTO projectCrops(MonthEnum monthEnum, List<ProductsToProject> products) {
        var projection = new ArrayList<ProjectCrops>(products.size());
        var total=0.0;
        var totalCrops = 0.0;
        for(var productToProject: products){
            var productPrice = getProductPricePort.getProductPrice(productToProject.getProductId(), monthEnum.getValue());
            var product = getProductUseCase.getProductById(productToProject.getProductId());

            var crops = productToProject.getSoldSacks()/product.getRelationSacks();
            crops = Math.floor(crops*100)/100;

            var subtotal = productPrice.getUnitPricing()*productToProject.getSoldSacks();
            total+=subtotal;
            totalCrops+=crops;
            projection.add(ProjectCrops.builder().relationSacks(product.getRelationSacks()).crops(crops).unitPricing(productPrice.getUnitPricing()).subtotal(subtotal)
                    .productSacks(productToProject.getSoldSacks()).productName(product.getProductName()).build());
        }
        total = Math.floor(total*100)/100;
        totalCrops = Math.floor(totalCrops*100)/100;
        return ProjectionCropsDTO.builder().projectCrops(projection).month(monthEnum).total(total).totalCrops(totalCrops).build();
    }
}
