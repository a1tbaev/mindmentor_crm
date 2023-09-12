package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.entity.History;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.HistoryMapper;
import kg.nsi.crm.repository.HistoryRepository;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.service.HistoryGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryGeneratorServiceImpl implements HistoryGeneratorService {

    private final HistoryRepository historyRepository;
    private final InternRepository internRepository;

    @Override
    public void forSave(HistoryResponse historyResponse, Long internId) {
        History history = HistoryMapper.toEntity(historyResponse);
        Intern intern = internRepository.findById(internId)
                .orElseThrow(()-> new NotFoundException("Intern not found with id: " + internId));

        history.setIntern(intern);
        historyRepository.save(history);
    }

}
