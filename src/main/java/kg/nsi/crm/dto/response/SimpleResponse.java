package kg.nsi.crm.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record SimpleResponse (
        String message,
        HttpStatus httpStatus
){
}