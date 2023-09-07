package kg.nsi.crm.service.impl;

import
        jakarta.transaction.Transactional;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MentorServiceImpl implements MentorService {
    private final StackRepository stackRepository;
    private final MentorRepository mentorRepository;
    private final InternRepository internRepository;

    @Override
    public SimpleResponse createMentor(@NotNull MentorRequest mentorRequest) {

        Mentor mentor = new Mentor();

        mentor.setFirstName(mentorRequest.firstName());
        mentor.setLastName(mentorRequest.lastName());
        mentor.setEmail(mentorRequest.email());
        mentor.setPhoneNumber(mentorRequest.phoneNumber());
        mentor.setIsBillable(mentorRequest.isBillable());
        mentor.setCreationDate(LocalDate.now());
        method(mentorRequest.stackIDies(),mentor);
        mentorRepository.save(mentor);
        return new SimpleResponse("The mentor created successfully", HttpStatus.OK);
    }

    @Override
    public SimpleResponse deleteMentor(Long mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s not found!", mentorId)));

        List<Intern> interns = internRepository.findByMentorId(mentorId);

        for (Intern intern : interns) {
            intern.setMentor(null);
        }

        internRepository.saveAll(interns);
        mentorRepository.delete(mentor);

        return SimpleResponse.builder()
                .message(String.format("Mentor with name %s successfully deleted!", (mentor.getFirstName() + " " + mentor.getLastName())))
                .httpStatus(HttpStatus.OK)
                .build();
    }
    private void method(List<Long>allStack,Mentor mentor){
        if (allStack != null) {
            Set<Stack> allStackById = new HashSet<>(stackRepository.findAllById(allStack));
            mentor.setStacks(allStackById);
        }
    }

    @Override
    public SimpleResponse updateMentor(Long id, MentorRequest newMentor) {
        Mentor oldMentor = mentorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s not found!", id)));
        if (newMentor.firstName() != null) oldMentor.setFirstName(newMentor.firstName());
        if (newMentor.lastName() != null) oldMentor.setLastName(newMentor.lastName());
        if (newMentor.email() != null) oldMentor.setEmail(newMentor.email());
        if (newMentor.phoneNumber() != null) oldMentor.setPhoneNumber(newMentor.phoneNumber());
        if (newMentor.isBillable() != null) oldMentor.setIsBillable(newMentor.isBillable());
        method(newMentor.stackIDies(),oldMentor);
        mentorRepository.save(oldMentor);
        return new SimpleResponse("The mentor successfully updated!", HttpStatus.OK);
    }
}
