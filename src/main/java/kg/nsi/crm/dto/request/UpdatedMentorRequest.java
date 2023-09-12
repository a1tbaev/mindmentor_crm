package kg.nsi.crm.dto.request;

import kg.nsi.crm.entity.Stack;
import lombok.Builder;

import java.util.Set;

@Builder
public record UpdatedMentorRequest (
        String firstName,
        String lastName,
        String email,
        Boolean isBillable,
        String education,
        String experience,
        Set<String> stacks

){}
