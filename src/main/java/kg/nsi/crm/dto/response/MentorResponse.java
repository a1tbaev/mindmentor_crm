package kg.nsi.crm.dto.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MentorResponse {
    Long id;
    List<String> stackNames;
    String firstname;
    String lastname;
    String email;
    String skills;
    String education;
    String experience;
    String phoneNumber;
    boolean isBillable;
}
