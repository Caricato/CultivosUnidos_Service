package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.helpers.PasswordHelper;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetValidatedUserDTO;
import org.sistema.arroz.riceservice.modules.users.application.port.in.LoginToValidate;
import org.sistema.arroz.riceservice.modules.users.application.port.in.ValidateLoginUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.GetUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.LoginInvalidException;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

@UseCase
@RequiredArgsConstructor
public class ValidateLoginService implements ValidateLoginUseCase {
    private final GetUserPort getUserPort;
    private final PasswordHelper passwordHelper;
    private final GetProducerUseCase getProducerUseCase;

    @Override
    public GetValidatedUserDTO validateLogin(LoginToValidate loginToValidate) {
        var user = getUserPort.getUser(loginToValidate.getUsername());
        var checkLogin = passwordHelper.areSamePasswords(loginToValidate.getPassword(), user.getPassword());
        if (!checkLogin) throw new LoginInvalidException(loginToValidate.getUsername());

        if (user.getRole().equals(UserRole.PRODUCER)){
            var producer = getProducerUseCase.getProducer(user.getUsername());
            return GetValidatedUserDTO.builder().userId(user.getUserId())
                    .communityId(producer.getCommunity().getCommunityId()).communityName(producer.getCommunity().getCommunityName())
                    .role(user.getRole()).userName(producer.getProducerName()).userFirstLastName(producer.getProducerFirstLastName())
                    .userSecondLastName(producer.getProducerSecondLastName())
                    .build();
        }
        return null;
    }
}
