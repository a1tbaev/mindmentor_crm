package kg.nsi.crm.controller;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorService mentorService;

    @PostMapping
    public SimpleResponse createMentor(@RequestBody MentorRequest mentorRequest){
        return mentorService.createMentor(mentorRequest);
    }
}
