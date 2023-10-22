package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.InterviewResponse;
import kg.nsi.crm.dto.request.InterviewRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Interview", description = "The interview api")
@RequestMapping("/api/interview")
public class InterviewController {
    private final InterviewService interviewService;

    @PostMapping
    @Operation(summary = "Save interview", description = "This method to saving interview")
    SimpleResponse save(InterviewRequest interviewRequest){
        return interviewService.save(interviewRequest);
    }

    @GetMapping
    @Operation(summary = "get all interviews", description = "This method to get all interview")
    public List<InterviewResponse> getAll(){
        return interviewService.getAll();
    }

    @DeleteMapping("/{interviewId}")
    @Operation(summary = "delete interviews", description = "This method to delete")
    public SimpleResponse delete(@PathVariable Long interviewId){
        return interviewService.delete(interviewId);
    }
}
