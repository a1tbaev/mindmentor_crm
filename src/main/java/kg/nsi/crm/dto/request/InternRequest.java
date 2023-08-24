package kg.nsi.crm.dto.request;

import kg.nsi.crm.enums.InternStatus;
import lombok.Builder;

@Builder
public record InternRequest (

        String name,
        String surname,
        String email,
        String phoneNumber,
        Long stackId,
        boolean isPaid,
        Long mentorId,
        InternStatus internStatus

){
}
