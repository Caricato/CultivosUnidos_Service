package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.mappers.SaleMapper;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories.SpringJpaSaleRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class SalePersistenceAdapter {
    private final SpringJpaSaleRepository saleRepository;
    private final SaleMapper saleMapper;
}
