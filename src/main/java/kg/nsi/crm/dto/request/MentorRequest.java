package kg.nsi.crm.dto.request;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentorRequest {
        String firstName;
        String lastName;
        String email;
        List<Long> stackIds;
        Boolean isBillable;
}
