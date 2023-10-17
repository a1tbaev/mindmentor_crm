package kg.nsi.crm.dto.response;

import kg.nsi.crm.enums.InternStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public InternResponse(Long id, String firstName, String lastName, String groupName, String stackName, InternStatus internStatus, String mentorName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupName = groupName;
        this.stackName = stackName;
        this.internStatus = internStatus;
        this.mentorName = mentorName;
    }
}
