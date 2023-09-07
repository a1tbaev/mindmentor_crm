package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.entity.History;
import kg.nsi.crm.mapper.HistoryMapper;
import kg.nsi.crm.repository.HistoryRepository;
import kg.nsi.crm.service.HistoryGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryGeneratorServiceImpl implements HistoryGeneratorService {

    private final HistoryRepository historyRepository;

    @Override
    public void forSave(HistoryResponse historyResponse) {
        History history = HistoryMapper.toEntity(historyResponse);
        historyRepository.save(history);
    }

}
