package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.HistoryRequest;
import kg.nsi.crm.dto.response.HistoryOwnerNameResponse;
import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.History;

import java.util.List;

public interface HistoryGeneratorService {
    void forSave(HistoryRequest historyRequest, Long internId);
    History findHistoryByInternId(Long id);
    SimpleResponse deleteAllByInternId(Long id);
    HistoryOwnerNameResponse getAllInternsHistory(Long internId);

}
