package kg.nsi.crm.dto.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record ResponseVacancy (
        String vacancyName,
        String developerLevel,
        LocalDate date,
        String requirement
){

}
