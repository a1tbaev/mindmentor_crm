package kg.nsi.crm.dto;



import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceDto {
    private String description;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobTitle;
    private String location;
}
