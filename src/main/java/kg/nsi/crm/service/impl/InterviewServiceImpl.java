package kg.nsi.crm.service.impl;

import jakarta.transaction.Transactional;
import kg.nsi.crm.dto.request.InterviewRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Interview;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.InterviewRepository;
import kg.nsi.crm.service.EmailService;
import kg.nsi.crm.service.InterviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InterviewServiceImpl implements InterviewService {
    private final InternRepository internRepository;
    private final InterviewRepository interviewRepository;
    private final EmailService emailService;
    private final TemplateEngine templateEngine;

    @Override
    public SimpleResponse save(InterviewRequest interviewRequest) {
        List<Intern> interns = internRepository.findAllById(interviewRequest.internIdes());
        Interview interview = new Interview();
        interview.setNameOfInterview(interviewRequest.nameOfInterview());
        interview.setStartDate(interviewRequest.date());
        interview.setStartTime(interviewRequest.startTime());
        interview.setEndTime(interviewRequest.endTime());
        interview.setLocation(interviewRequest.location());
        interview.setDescription(interviewRequest.description());
        interview.setInterns(interns);

        interviewRepository.save(interview);
        String subject = "Interview";

//        for (Intern intern : interns) {

        Intern intern = interns.get(0);

            Context context = new Context();

            context.setVariable("name", intern.getFirstName());
            context.setVariable("interviewName", interviewRequest.nameOfInterview());
            context.setVariable("interviewDate", interviewRequest.date());
            context.setVariable("startTime", interviewRequest.startTime());
            context.setVariable("endTime", interviewRequest.endTime());
            context.setVariable("location", interviewRequest.location());
            context.setVariable("description", interviewRequest.description());

            String htmlContent = templateEngine.process("templates/interview.html", context);

            emailService.sendEmail(intern.getEmail(), subject, htmlContent);
//        }

        return SimpleResponse.builder()
                .message("Interview was successfully saved, and notifications sent to interns.")
                .httpStatus(HttpStatus.OK)
                .build();
    }

}
