package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.entity.History;

import java.time.LocalDate;

public class HistoryMapper {
    public static History toEntity(HistoryResponse historyResponse){
        return History.builder()
                .date(LocalDate.now())
                .message(historyResponse.message())
                .build();
    }
}
