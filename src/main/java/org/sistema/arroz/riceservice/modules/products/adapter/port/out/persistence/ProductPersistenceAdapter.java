package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.out.*;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements RegisterProductPort, EditProductPort, DeleteProductPort, GetProductsPort, GetProductPort, GetAllProductsPort {
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
        productJpa.setStock(productToEdit.getStock());
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

    @Override
    public Optional<Product> getProductById(Long productId) {
        var productJpa = productRepository.findById(productId);
        return productJpa.map(productMapper::toProduct);
    }

    @Override
    public List<Product> getAllProducts(Long productId) {
        var productsJpa = productRepository.findAllByCommunityJpaEntity_CommunityIdAndState(productId, true);
        return productMapper.toProducts(productsJpa);
    }
}
