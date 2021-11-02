package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.ScheduleParametersToRegister;
import org.sistema.arroz.riceservice.modules.parameters.application.port.out.EditScheduleParametersPort;
import org.sistema.arroz.riceservice.modules.parameters.application.port.out.GetParametersPort;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;
import org.sistema.arroz.riceservice.modules.parameters.domain.ParametersNotFoundException;

@PersistenceAdapter
@RequiredArgsConstructor
public class ParametersPersistenceAdapter implements GetParametersPort, EditScheduleParametersPort {
    private final ParametersMapper parametersMapper;
    private final SpringJpaParametersRepository parametersRepository;

    @Override
    public Parameters getParameters(Long communityId) {
        var parameters = parametersRepository.findByCommunity_CommunityId(communityId);
        if (parameters.isEmpty()) throw new ParametersNotFoundException();
        return parametersMapper.toParameters(parameters.get());
    }

    @Override
    public Parameters editScheduleParameters(Long communityId, ScheduleParametersToRegister scheduleParametersToRegister) {
        var parameters = parametersRepository.findByCommunity_CommunityId(communityId);
        if (parameters.isEmpty()) throw new ParametersNotFoundException();
        parameters.get().setDurationSchedule(scheduleParametersToRegister.getValue());
        var result = parametersRepository.save(parameters.get());
        return parametersMapper.toParameters(result);
    }
}
