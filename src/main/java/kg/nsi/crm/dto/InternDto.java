package kg.nsi.crm.dto;

import java.time.LocalDate;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kg.nsi.crm.enums.InternStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternDto{

    private Long id;

    private LocalDate creationDate;

    private LocalDate updateDate;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Boolean isPaidForFirstMonth;
    private Boolean isPaidForSecondMonth;
    private Boolean isPaidForThirdMonth;
    private GroupDto groupDto;
    private String stack;

    @Enumerated(EnumType.STRING)
    private InternStatus internStatus;
   
}
