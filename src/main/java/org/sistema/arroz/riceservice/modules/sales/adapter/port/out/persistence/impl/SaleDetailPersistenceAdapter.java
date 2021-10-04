package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.mappers.SaleDetailMapper;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories.SpringJpaSaleDetailRepository;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.GetSaleDetailPort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.RegisterSaleDetailPort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.SaleDetailToPersist;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaleDetailPersistenceAdapter implements RegisterSaleDetailPort, GetSaleDetailPort {
    private final SpringJpaSaleDetailRepository saleDetailRepository;
    private final SaleDetailMapper saleDetailMapper;

    @Override
    public List<SaleDetail> registerSaleDetail(List<SaleDetailToPersist> saleDetailToPersist) {
        var entities = saleDetailMapper.toSaleDetailsJpa(saleDetailToPersist);
        var result = saleDetailRepository.saveAll(entities);
        return saleDetailMapper.toSaleDetails(result);
    }

    @Override
    public List<SaleDetail> getSaleDetail(Long saleId) {
        var result = saleDetailRepository.findAllBySale_SaleId(saleId);
        return saleDetailMapper.toSaleDetails(result);
    }
}
