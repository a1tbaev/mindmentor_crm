package kg.nsi.crm.dto.request;

import lombok.Builder;

@Builder
public record HistoryRequest(
        String message
) {
}
