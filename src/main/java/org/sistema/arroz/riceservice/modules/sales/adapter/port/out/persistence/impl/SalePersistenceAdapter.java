package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.mappers.SaleMapper;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories.SpringJpaSaleRepository;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.GetSalesPort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.RegisterSalePort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.SaleToPersist;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SalePersistenceAdapter implements RegisterSalePort, GetSalesPort {
    private final SpringJpaSaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public Sale registerSale(SaleToPersist saleToPersist) {
        var entity = saleMapper.toSaleJpa(saleToPersist);
        var result = saleRepository.save(entity);
        return saleMapper.toSale(result);
    }

    @Override
    public List<Sale> getSales(Long communityId, RangeDatesDTO datesDTO) {
        var entities = saleRepository.searchSalesForCommunity(communityId, datesDTO.getStartDate(), datesDTO.getEndDate());
        return saleMapper.toSales(entities);
    }
}
