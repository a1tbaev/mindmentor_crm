package kg.nsi.crm.service;

import kg.nsi.crm.dto.response.HistoryResponse;

public interface HistoryGeneratorService {
    void forSave(HistoryResponse historyResponse, Long internId);
}
