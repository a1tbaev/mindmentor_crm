package kg.nsi.crm.dto.response;


import kg.nsi.crm.dto.ExperienceDto;
import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExtractedDataDto {
    private String firstName;
    private String lastName;
    private ArrayList<String> email;
    private ArrayList<String> education;
    private ArrayList<ExperienceDto> experience;
    private ArrayList<String> stack;

}
