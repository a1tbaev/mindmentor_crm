package kg.nsi.crm.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record HistoryOwnerNameResponse (
        String fullName,
        List<HistoryResponse> historyResponses
){
}
