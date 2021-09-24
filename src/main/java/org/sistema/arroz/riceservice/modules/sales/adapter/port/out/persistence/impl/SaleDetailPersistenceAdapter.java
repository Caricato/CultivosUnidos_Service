package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.mappers.SaleDetailMapper;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories.SpringJpaSaleDetailRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaleDetailPersistenceAdapter {
    private final SpringJpaSaleDetailRepository saleDetailRepository;
    private final SaleDetailMapper saleDetailMapper;
}
