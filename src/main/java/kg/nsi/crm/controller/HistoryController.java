package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.response.HistoryOwnerNameResponse;
import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.HistoryGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@Tag(name = "History", description = "The History API")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryGeneratorService historyGeneratorService;

    @GetMapping("/{internId}")
    public HistoryOwnerNameResponse getAllInternsHistory(@PathVariable Long internId) {
        return historyGeneratorService.getAllInternsHistory(internId);
    }

    @DeleteMapping("/{internId}")
    public SimpleResponse deleteAllByInternId(@PathVariable Long internId){
        return historyGeneratorService.deleteAllByInternId(internId);
    }
}
