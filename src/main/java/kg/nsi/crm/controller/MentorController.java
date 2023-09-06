package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;

    @PostMapping
    public SimpleResponse createMentor(@RequestBody MentorRequest mentorRequest){
        return mentorService.createMentor(mentorRequest);
    }

    @DeleteMapping
    @Operation(summary = "Delete mentor", description = "This method to delete mentor!")
    public SimpleResponse deletedMentor(@RequestParam Long mentorId){
        return mentorService.deleteMentor(mentorId);
    }

    @PutMapping
    @Operation(summary = "Update mentor", description = "This method to update mentor!")
    public SimpleResponse updateMentor(@RequestBody MentorRequest request,@RequestParam Long mentorId){
        return mentorService.updateMentor(mentorId,request);
    }



}
