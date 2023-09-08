package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.dto.response.SimpleResponse;

import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

    @Operation(summary = "Extracting the mentor's data from CV", description = "This method is to extract info from CV")
    @GetMapping(name = "/getExtractedData",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ExtractedDataDto getExtractedDataFromCv(@RequestParam("file") MultipartFile file, @ModelAttribute MentorRequest mentorRequest){

        return mentorService.getExtractedDataFromCv(mentorRequest,file);
    }


    @DeleteMapping
    @Operation(summary = "Delete the mentor", description = "This method to delete the mentor by id")
    public SimpleResponse deletedMentor(@RequestParam Long mentorId){
        return mentorService.deleteMentor(mentorId);
    }

    @PutMapping
    @Operation(summary = "Update mentor", description = "This method to update mentor!")
    public SimpleResponse updateMentor(@RequestBody MentorRequest request,@RequestParam Long mentorId){
        return mentorService.updateMentor(mentorId,request);
    }

    @Operation(summary = "Create a new mentor", description = "This method is to create a new mentor!")
    @PostMapping
    public SimpleResponse createMentor(@RequestBody UpdatedMentorRequest updatedMentorRequest){
        return mentorService.createMentor(updatedMentorRequest);
    }




}
