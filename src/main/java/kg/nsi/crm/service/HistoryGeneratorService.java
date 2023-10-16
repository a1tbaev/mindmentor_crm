package kg.nsi.crm.service;

import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.entity.History;
import kg.nsi.crm.entity.Intern;

public interface HistoryGeneratorService {
    void forSave(HistoryResponse historyResponse, Long internId);
    History findHistoryByInternId(Long id);
    void deleteAllByInternId(Long id);
}
