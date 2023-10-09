package kg.nsi.crm.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MentorResponse {
    Long id;
    String firstname;
    String lastname;
    String email;
    String skills;
    String education;
    String experience;
    boolean isBillable;
}
