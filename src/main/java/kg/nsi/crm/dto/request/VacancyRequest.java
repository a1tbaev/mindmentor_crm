package kg.nsi.crm.dto.request;

import lombok.Builder;

@Builder
public record VacancyRequest(
        Long companyId,
        String vacancyName,
        String level,
        String requirement
) {
}
