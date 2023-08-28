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
    private String fullName;
    private ArrayList<String> email;
    private ArrayList<String> education;
    private ArrayList<ExperienceDto> experience;
    private String selfSummary;
    private ArrayList<String> phoneNumbers;
    private ArrayList<String> stack;
    private ArrayList<String> urls;

}
