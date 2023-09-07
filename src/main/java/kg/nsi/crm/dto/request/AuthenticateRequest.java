package kg.nsi.crm.dto.request;

import kg.nsi.crm.validation.PasswordValid;
import lombok.Builder;

@Builder
public record AuthenticateRequest (
        String userName,
        @PasswordValid
        String password
){
}
