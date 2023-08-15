package kg.nsi.crm.dto.request;

import lombok.Builder;

@Builder
public record AuthenticateRequest (
        String userName,
        String password
){
}
