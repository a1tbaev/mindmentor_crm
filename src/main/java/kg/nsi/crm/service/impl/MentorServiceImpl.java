package kg.nsi.crm.service.impl;

import jakarta.transaction.Transactional;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MentorServiceImpl implements MentorService {
    private final StackRepository stackRepository;
    private final MentorRepository mentorRepository;

    @Override
    public SimpleResponse createMentor(MentorRequest mentorRequest) {

        Mentor mentor = new Mentor();

        mentor.setFirstName(mentorRequest.firstName());
        mentor.setLastName(mentorRequest.lastName());
        mentor.setEmail(mentorRequest.email());
        mentor.setPhoneNumber(mentorRequest.phoneNumber());
        mentor.setIsBillable(mentorRequest.isBillable());
        mentor.setCreationDate(LocalDate.now());

        if (mentorRequest.stackIDies() != null){
            Set<Stack> allStackById = new HashSet<>(stackRepository.findAllById(mentorRequest.stackIDies()));
            mentor.setStacks(allStackById);
        }
        mentorRepository.save(mentor);
        return new SimpleResponse( "The mentor created successfully", HttpStatus.OK);
    }
}
