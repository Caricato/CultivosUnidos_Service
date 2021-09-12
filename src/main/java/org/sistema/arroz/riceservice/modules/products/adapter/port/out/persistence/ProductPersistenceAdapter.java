package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.out.DeleteProductPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.EditProductPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductsPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;
import org.springframework.data.domain.PageRequest;

import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements RegisterProductPort, EditProductPort, DeleteProductPort, GetProductsPort {
    private final SpringJpaProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AgricultureCommunityMapper agricultureCommunityMapper;

    @Override
    public Product registerProduct(ProductToRegister productToRegister, AgricultureCommunity agricultureCommunity) {
        var productJpa = productMapper.toProductJpaEntity(productToRegister);
        productJpa.setCommunityJpaEntity(agricultureCommunityMapper.toAgricultureCommunityJpaEntity(agricultureCommunity));
        productJpa.setState(true);  
        var result = productRepository.save(productJpa);
        return productMapper.toProduct(result);
    }

    @Override
    public Product editProduct(ProductToEdit productToEdit, Long productId) {
        var productJpaEntityOptional = productRepository.findById(productId);
        if (productJpaEntityOptional.isEmpty()) throw new ProductNotFoundException(productId);
        var productJpa = productJpaEntityOptional.get();
        productJpa.setProductName(productToEdit.getProductName());
        productJpa.setSacks(productToEdit.getSacks());
        var result = productRepository.save(productJpa);
        return productMapper.toProduct(result);
    }

    @Override
    public Long deleteProduct(Long productId) {
        var productJpaEntityOptional = productRepository.findById(productId);
        if (productJpaEntityOptional.isEmpty()) throw new ProductNotFoundException(productId);
        var productJpa = productJpaEntityOptional.get();

        productJpa.setState(false);
        var result = productRepository.save(productJpa);
        return productId;
    }

    @Override
    public Paginator<Product> getProducts(Filters filters, Long communityId) {
        var pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
        var page = productRepository.searchProducts(pageable, filters.getSearch(), communityId, true);
        var data = page.getContent()
                .stream().map(productMapper::toProduct)
                .collect(Collectors.toList());

        return Paginator.<Product>builder()
                .page(filters.getPage())
                .pageSize(filters.getPageSize())
                .total(page.getTotalElements())
                .data(data)
                .build();
    }
}
