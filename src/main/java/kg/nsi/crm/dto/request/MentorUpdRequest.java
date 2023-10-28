package kg.nsi.crm.dto.request;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MentorUpdRequest {
    String firstname;
    String lastname;
    String email;
    String skills;
    String education;
    String experience;
    String phoneNumber;
    boolean isBillable;
    List<String> stackNames;
}