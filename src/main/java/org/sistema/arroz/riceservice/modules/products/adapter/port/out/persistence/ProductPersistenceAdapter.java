package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.out.EditProductPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements RegisterProductPort, EditProductPort {
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
        var result = productRepository.save(productJpa);
        return productMapper.toProduct(result);
    }
}
