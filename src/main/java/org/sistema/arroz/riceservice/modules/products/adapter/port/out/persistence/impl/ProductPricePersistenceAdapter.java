package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductPriceMapper;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.repositories.SpringJpaProductPriceRepository;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.repositories.SpringJpaProductRepository;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductPriceToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.out.DeleteProductPricesPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPricePort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPricesPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPricesPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import javax.transaction.Transactional;
import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPricePersistenceAdapter implements RegisterProductPricesPort, GetProductPricePort, GetProductPricesPort, DeleteProductPricesPort {
    private final ProductPriceMapper productPriceMapper;
    private final SpringJpaProductRepository productRepository;
    private final SpringJpaProductPriceRepository productPriceRepository;

    @Override
    public List<ProductPrice> registerProductPrices(List<ProductPriceToRegister> productPricesToRegister, Long productId) {
        var productPricesJpa = productPriceMapper.toProductPricesJpa(productPricesToRegister);
        var product = productRepository.findById(productId);
        if (product.isEmpty()) throw new ProductNotFoundException(productId);
        for (var productPrice: productPricesJpa){
            productPrice.setProduct(product.get());
        }
        var result = productPriceRepository.saveAll(productPricesJpa);
        return productPriceMapper.toProductPrices(result);
    }

    @Override
    public ProductPrice getProductPrice(Long productId, Integer month) {
        var entityJpa = productPriceRepository.findByProduct_ProductIdAndMonth(productId, month);
        return productPriceMapper.toProductPrice(entityJpa);
    }

    @Override
    public List<ProductPrice> getProductPrices(Long productId) {
        var entities = productPriceRepository.findByProduct_ProductId(productId);
        return productPriceMapper.toProductPrices(entities);
    }

    @Transactional
    @Override
    public void deleteProductPrices(Long productId) {
        var entities = productPriceRepository.findByProduct_ProductId(productId);
        if (!entities.isEmpty()) productPriceRepository.deleteAllByProduct_ProductId(productId);
    }
}
