package kg.nsi.crm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.mapper.MentorMapper;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.MentorService;
import kg.nsi.crm.service.impl.MentorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Tag(name = "Mentor", description = "The Mentor API")
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;
    private final MentorRepository mentorRepository;
    private final StackRepository stackRepository;

    @Operation(summary = "Create a new mentor", description = "This method to create a new mentor")
    @PostMapping
    public SimpleResponse createMentor(@RequestParam("file") MultipartFile file, @RequestBody MentorRequest mentorRequest){

        Mentor mentor = MentorMapper.toEntity(mentorRequest);


        return mentorService.createMentor(mentorRequest);
    }


    @DeleteMapping
    @Operation(summary = "Delete the mentor", description = "This method to delete the mentor by id")
    public SimpleResponse deletedMentor(@RequestParam Long mentorId){
        return mentorService.deleteMentor(mentorId);
    }
}
