package kg.nsi.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.InternResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.request.HistoryRequest;
import kg.nsi.crm.entity.History;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.HistoryGeneratorService;
import kg.nsi.crm.service.PaymentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.mapper.InternMapper;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.service.InternService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InternServiceImpl implements InternService {

    final InternRepository internRepository;
    final MentorRepository mentorRepository;
    final StackRepository stackRepository;
    final PaymentService paymentService;
    final HistoryGeneratorService historyGeneratorService;

    @Override
    public SimpleResponse createIntern(InternRequest internRequest) {

        if (internRepository.existsByEmail(internRequest.email()))
            return new SimpleResponse("Intern with which email already exists", HttpStatus.BAD_REQUEST);

        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));

        Intern internToSave = InternMapper.toDto(internRequest, mentor, stack);
        internRepository.save(internToSave);

        // Make sure that internToSave is not null before trying to get its ID
        if (internToSave != null) {
            historyGeneratorService.forSave(HistoryRequest.builder()
                    .message("Intern has been registered")
                    .build(), internToSave.getId());
        } else {
            return new SimpleResponse("!!!problem!!!", HttpStatus.BAD_REQUEST);
        }

        return new SimpleResponse("The intern created successfully", HttpStatus.OK);
    }


    @Override
    public InternDto getInternById(Long id) {
        Intern intern = internRepository.findById(id).orElseThrow();
        if (intern.getGroup() != null) paymentService.processPayment(intern);
        return getInternEntityById(id);
    }

    @Override
    public SimpleResponse deleteInternById(Long id) {
        Intern intern = internRepository.getInternById(id);

        intern.setMentor(null);
        intern.setStack(null);
        intern.setGroup(null);

        History history = historyGeneratorService.findHistoryByInternId(id);
        if (history != null) history.setIntern(null);
        internRepository.save(intern);
        internRepository.delete(intern);
        return new SimpleResponse("The intern deleted successfully", HttpStatus.OK);
    }

    @Override
    public SimpleResponse updateIntern(InternRequest internRequest, Long id) {
        Intern intern = this.internRepository.getInternById(id);

        if (internRequest.name() != null) intern.setFirstName(internRequest.name());
        if (internRequest.surname() != null) intern.setLastName(internRequest.surname());
        if (internRequest.email() != null) intern.setEmail(internRequest.email());
        if (internRequest.phoneNumber() != null) intern.setPhoneNumber(internRequest.phoneNumber());
        if (internRequest.internStatus() != null) intern.setInternStatus(internRequest.internStatus());

        historyGeneratorService.forSave(HistoryRequest.builder()
                .message("Intern with name: " + intern.getFirstName() + "updated")
                .build(), intern.getId());

        internRepository.save(intern);
        return new SimpleResponse("The mentor updated successfully", HttpStatus.OK);
    }


    @Override
    public List<InternResponse> getAll(PageRequest pageRequest) {
        return internRepository.getAll();
    }

    @Override
    public InternDto getInternEntityById(Long id) {
        return InternMapper.toEntity(internRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Intern with id %s is not found!", id))));
    }

    @Override
    public List<InternResponse> getInternsByName(String name) {
        List<Intern> interns = internRepository.getInternsByFirstName(name);
        List<InternResponse> internResponses = new ArrayList<>();

        for (Intern intern : interns) {
            InternResponse internResponse = new InternResponse();
            internResponse.setId(intern.getId());
            internResponse.setFirstName(intern.getFirstName());
            internResponse.setLastName(intern.getLastName());
            internResponse.setStackName(intern.getStack().getName());
            internResponses.add(internResponse);
        }
        return internResponses;
    }

    @Override
    public List<InternResponse> getInternsByStatus(InternStatus status) {
        List<Intern> interns = internRepository.findAll();
        List<InternResponse> internResponses = new ArrayList<>();
        for(Intern intern : interns){
            if(intern.getInternStatus().equals(status)){
                InternResponse internResponse = new InternResponse();
                internResponse.setId(intern.getId());
                internResponse.setFirstName(intern.getFirstName());
                internResponse.setLastName(intern.getLastName());
                if(intern.getStack() != null) internResponse.setStackName(intern.getStack().getName());
                else{
                    internResponse.setStackName("Not Assigned Yet");
                }
                internResponse.setInternStatus(intern.getInternStatus());
                if(intern.getMentor() != null) internResponse.setMentorName(intern.getMentor().getFirstName());
                else{
                    internResponse.setMentorName("Not Assigned Yet");
                }
                if(intern.getGroup() != null) internResponse.setGroupName(intern.getGroup().getName());
                else{
                    internResponse.setGroupName("Not Assigned Yet");
                }
                internResponses.add(internResponse);
            }
        }


        return internResponses;
    }




}
