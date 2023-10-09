package kg.nsi.crm.service.impl;

import jakarta.transaction.Transactional;
import kg.nsi.crm.dto.InterviewResponse;
import kg.nsi.crm.dto.request.InterviewRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Interview;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.InterviewRepository;
import kg.nsi.crm.repository.custom.InterviewCustom;
import kg.nsi.crm.service.EmailService;
import kg.nsi.crm.service.InterviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private final JdbcTemplate jdbcTemplate;

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

        for (Intern intern : interns) {

            Context context = new Context();

            context.setVariable("name","Dear " + intern.getFirstName());
            context.setVariable("interviewName", "Interview name: " + interviewRequest.nameOfInterview());
            context.setVariable("interviewDate", "Date: " + interviewRequest.date());
            context.setVariable("startTime", "Start time: " + interviewRequest.startTime());
            context.setVariable("endTime", "End time: " + interviewRequest.endTime());
            context.setVariable("location", "Location: " + interviewRequest.location());
            context.setVariable("description", "Description: " + interviewRequest.description());

            String htmlContent = templateEngine.process("interview.html", context);

            emailService.sendEmail(intern.getEmail(), subject, htmlContent);
        }

        return SimpleResponse.builder()
                .message("Interview was successfully saved, and notifications sent to interns.")
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public List<InterviewResponse> getAll() {
        return jdbcTemplate.query(new InterviewCustom().getAllInterviews(), (resultSet, i)
                -> InterviewResponse.builder()
                        .name(resultSet.getString("full_name"))
                        .gmail(resultSet.getString("email"))
                        .stack(resultSet.getString("stack"))
                        .time(resultSet.getString("time"))
                        .date(resultSet.getDate("date").toLocalDate())
                        .location(resultSet.getString("location"))
                .build()
        );
    }

    @Override
    public SimpleResponse delete(Long interviewId) {
        Interview interview = interviewRepository.findById(interviewId).orElseThrow(
                ()-> new NotFoundException("interview not found with id: " + interviewId));
        interview.setInterns(null);
        interviewRepository.save(interview);
        interviewRepository.deleteById(interviewId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("interview with successfully deleted : " + interviewId)
                .build();
    }
}
