package kg.nsi.crm.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record HistoryResponse(
        String fullName,
        String message,
        LocalDate date
) {
}
