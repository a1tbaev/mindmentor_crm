package kg.nsi.crm.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.MentorUpdRequest;
import kg.nsi.crm.dto.response.MentorResponse;
import kg.nsi.crm.dto.response.MentorResponse2;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Mentor", description = "The Mentor API")
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;

    @Operation(summary = "Create a new mentor", description = "Create a new mentor")
    @PostMapping(name = "/saveExtractedData",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SimpleResponse saveExtractedDataFromCv(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("name") String name,
                                                  @RequestParam("lastname") String lastname,
                                                  @RequestParam("email") String email,
                                                  @RequestParam("isBillable") boolean isBillable,
                                                  @RequestParam("stackIds") List<Long> stackIds,
                                                  @RequestParam("phoneNumber") String phoneNumber){

        MentorRequest mentorRequest = MentorRequest.builder()
                .firstName(name)
                .lastName(lastname)
                .email(email)
                .isBillable(isBillable)
                .stackIds(stackIds)
                .phoneNumber(phoneNumber)
                .build();
        return mentorService.saveExtractedDataFromCv(mentorRequest,file);

    }

    @DeleteMapping
    @Operation(summary = "Delete the mentor", description = "This method to delete the mentor by id")
    public SimpleResponse deletedMentor(@RequestParam Long mentorId){
        return mentorService.deleteMentor(mentorId);
    }

    @PutMapping
    @Operation(summary = "Update mentor", description = "This method to update mentor!")
    public SimpleResponse updateMentor(@RequestBody MentorUpdRequest request, @RequestParam Long mentorId){
        return mentorService.updateMentor(mentorId,request);
    }

    @Operation(summary = "Get mentor's info", description = "This method is to get a mentor!")
    @GetMapping
    public MentorResponse getMentor(@RequestParam Long mentorId){
        return mentorService.getMentor(mentorId);
    }

    @Operation(summary = "Get all the mentors", description = "This method is to get all the mentors!")
    @GetMapping("/getAll")
    public List<MentorResponse> getAll(){
        return mentorService.getAll();
    }

    @Operation(summary = "Get all the mentors (for editing page)", description = "This method is to get all the mentors (editing page)")
    @GetMapping("/findAll")
    public List<MentorResponse2> findAll(){
        return mentorService.findAll();
    }
}
