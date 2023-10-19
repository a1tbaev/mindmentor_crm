package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.request.HistoryRequest;
import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.History;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.HistoryMapper;
import kg.nsi.crm.repository.HistoryRepository;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.service.HistoryGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryGeneratorServiceImpl implements HistoryGeneratorService {

    private final HistoryRepository historyRepository;
    private final InternRepository internRepository;


    @Override
    public void forSave(HistoryRequest historyRequest, Long internId) {
        History history = HistoryMapper.toEntity(historyRequest);
        Intern intern = internRepository.findById(internId)
                .orElseThrow(()-> new NotFoundException("Intern not found with id: " + internId));

        history.setIntern(intern);
        historyRepository.save(history);
    }

    @Override
    public History findHistoryByInternId(Long id) {
        return historyRepository.getByInternId(id);
    }

    @Override
    public SimpleResponse deleteAllByInternId(Long id) {
        for (History history : historyRepository.findAllByInternId(id)) {
            history.setIntern(null);
            historyRepository.save(history);
            historyRepository.delete(history);
        }
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }

    @Override
    public List<HistoryResponse> getAllInternsHistory(Long internId) {
        List<History> histories = historyRepository.findAllByInternId(internId);
        List<HistoryResponse> historyResponses = new ArrayList<>();
        for (History history : histories) {
            historyResponses.add(HistoryMapper.toDto(history));
        }
        return historyResponses;
    }
}
