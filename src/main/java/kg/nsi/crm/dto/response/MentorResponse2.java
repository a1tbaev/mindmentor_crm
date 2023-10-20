package kg.nsi.crm.dto.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MentorResponse2 {
    Long id;
    List<String> stackNames;
    String firstname;
    String lastname;
    String email;
    String education;
    String experience;
    boolean isBillable;
}
