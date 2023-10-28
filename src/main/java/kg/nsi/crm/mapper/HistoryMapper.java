package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.HistoryRequest;
import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.entity.History;

import java.time.LocalDate;

public class HistoryMapper {
    public static History toEntity(HistoryRequest historyRequest){
        return History.builder()
                .date(LocalDate.now())
                .message(historyRequest.message())
                .build();
    }

    public static HistoryResponse toDto(History history){

        return HistoryResponse
                .builder()
                .date(history.getDate())
                .message(history.getMessage())
                .build();

    }
}
