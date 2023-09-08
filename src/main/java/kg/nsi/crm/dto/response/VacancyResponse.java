package kg.nsi.crm.dto.response;

import kg.nsi.crm.enums.DeveloperLevel;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record VacancyResponse (
        String stackName,
        DeveloperLevel level,
        LocalDate date
) {
}
