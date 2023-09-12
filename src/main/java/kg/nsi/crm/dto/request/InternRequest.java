package kg.nsi.crm.dto.request;

import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.validation.PhoneNumberValid;
import lombok.Builder;

@Builder
public record InternRequest (
        String name,
        String surname,
        String email,
        @PhoneNumberValid
        String phoneNumber,
        Long stackId,
        Long mentorId,
        Integer paymentCoast,
        InternStatus internStatus

){
}
