package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.parameters.application.port.out.GetParametersPort;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;
import org.sistema.arroz.riceservice.modules.parameters.domain.ParametersNotFoundException;

@PersistenceAdapter
@RequiredArgsConstructor
public class ParametersPersistenceAdapter implements GetParametersPort {
    private final ParametersMapper parametersMapper;
    private final SpringJpaParametersRepository parametersRepository;

    @Override
    public Parameters getParameters() {
        var parameters = parametersRepository.findById(1L);
        if (parameters.isEmpty()) throw new ParametersNotFoundException();
        return parametersMapper.toParameters(parameters.get());
    }
}
