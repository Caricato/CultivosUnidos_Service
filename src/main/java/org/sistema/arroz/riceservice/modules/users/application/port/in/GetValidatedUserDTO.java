package org.sistema.arroz.riceservice.modules.users.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetValidatedUserDTO {
    Long userId;
    Long communityId;
    String communityName;
    UserRole role;
    String userName;
    String userFirstLastName;
    String userSecondLastName;
}
