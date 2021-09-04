package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements RegisterProductPort {
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
}
