package kg.nsi.crm.dto.response;

import kg.nsi.crm.enums.InternStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InternResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String groupName;
    private String stackName;
    private InternStatus internStatus;
    private String mentorName;
}
