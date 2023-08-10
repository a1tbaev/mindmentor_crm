package kg.nsi.crm.dto.response;

import kg.nsi.crm.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticateResponse (
        String userName,
        Role role,
        String token
){
}
