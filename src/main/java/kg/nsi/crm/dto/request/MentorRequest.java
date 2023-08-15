package kg.nsi.crm.dto.request;

import lombok.Builder;

import java.util.List;

@Builder
public record MentorRequest (
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        Boolean isBillable,
        List<Long> stackIDies
){
}
