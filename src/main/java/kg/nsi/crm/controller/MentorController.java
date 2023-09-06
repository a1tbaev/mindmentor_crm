package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Mentor", description = "The Mentor API")
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;

    @Operation(summary = "Create a new mentor", description = "This method to create a new mentor")
    @PostMapping
    public SimpleResponse createMentor(@RequestBody MentorRequest mentorRequest){
        return mentorService.createMentor(mentorRequest);
    }


    @DeleteMapping
    @Operation(summary = "Delete the mentor", description = "This method to delete the mentor by id")
    public SimpleResponse deletedMentor(@RequestParam Long mentorId){
        return mentorService.deleteMentor(mentorId);
    }
}
