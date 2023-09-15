package kg.nsi.crm.repository;

import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.InternMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InternRepositoryTests {
    @Autowired
    private InternRepository internRepository;
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private StackRepository stackRepository;

    @Test
    public void InternRepository_CreateIntern_ReturnIntern(){

        //Arrange
        InternRequest internRequest = InternRequest.builder()
                        .name("John")
                        .surname("Smith")
                        .email("johnsmith@gmail.com")
                        .phoneNumber("996777564534")
                        .stackId(1L)
                        .mentorId(1L)
                        .paymentCost(10000)
                        .internStatus(InternStatus.APPROVED)
                                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));

        //Act
        Intern savedIntern =  internRepository.save(InternMapper.toDto(internRequest, mentor, stack));


        //Assert
        Assertions.assertThat(savedIntern).isNotNull();
        Assertions.assertThat(savedIntern.getId()).isGreaterThan(0);
    }

    @Test
    public void InternRepository_GetAll_ReturnMoreThanOne(){
        //1
        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Smith")
                .email("johnsmith@gmail.com")
                .phoneNumber("996777564534")
                .stackId(1L)
                .mentorId(1L)
                .paymentCost(10000)
                .internStatus(InternStatus.APPROVED)
                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));


        //2
        InternRequest internRequest2 = InternRequest.builder()
                .name("Michele")
                .surname("Jordan")
                .email("michele@gmail.com")
                .phoneNumber("996777564534")
                .stackId(2L)
                .mentorId(2L)
                .paymentCost(10000)
                .internStatus(InternStatus.PENDING)
                .build();
        Stack stack2 = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor2 = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));


        internRepository.save(InternMapper.toDto(internRequest, mentor, stack));
        internRepository.save(InternMapper.toDto(internRequest2, mentor2, stack2));


        List<Intern> internsList = internRepository.findAll();


        Assertions.assertThat(internsList).isNotNull();
        Assertions.assertThat(internsList.size()).isEqualTo(5);

    }

    @Test
    public void InternRepository_GetInternById_ReturnIntern(){
        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Smith")
                .email("johnsmith@gmail.com")
                .phoneNumber("996777564534")
                .stackId(1L)
                .mentorId(1L)
                .paymentCost(10000)
                .internStatus(InternStatus.APPROVED)
                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));

        Intern savedIntern = internRepository.save(InternMapper.toDto(internRequest, mentor, stack));

        Intern intern = internRepository.getInternById(savedIntern.getId());

        Assertions.assertThat(intern).isNotNull();

    }

    @Test
    public void InternRepository_GetInternByEmail_ReturnIntern(){

        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Smith")
                .email("johnsmith@gmail.com")
                .phoneNumber("996777564534")
                .stackId(1L)
                .mentorId(1L)
                .paymentCost(10000)
                .internStatus(InternStatus.APPROVED)
                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));

        Intern savedIntern = internRepository.save(InternMapper.toDto(internRequest, mentor, stack));

        Intern intern = internRepository.getInternByEmail(savedIntern.getEmail());

        Assertions.assertThat(intern).isNotNull();
    }

    @Test
    public void InternRepository_GetInternByMentorId_ReturnIntern(){

        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Smith")
                .email("johnsmith@gmail.com")
                .phoneNumber("996777564534")
                .stackId(1L)
                .mentorId(1L)
                .paymentCost(10000)
                .internStatus(InternStatus.APPROVED)
                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));

        Intern savedIntern = internRepository.save(InternMapper.toDto(internRequest, mentor, stack));

        List<Intern> intern = internRepository.findByMentorId(savedIntern.getId());

        Assertions.assertThat(intern).isNotNull();
    }

    @Test
    public void InternRepository_UpdateIntern_ReturnInternNoTNull(){
        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Smith")
                .email("johnsmith@gmail.com")
                .phoneNumber("996777564534")
                .stackId(1L)
                .mentorId(1L)
                .paymentCost(10000)
                .internStatus(InternStatus.PENDING)
                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));


        Intern intern = internRepository.save(InternMapper.toDto(internRequest, mentor, stack));


        Intern savedIntern = internRepository.getInternById(intern.getId());
        savedIntern.setEmail("john@gmail.com");
        savedIntern.setInternStatus(InternStatus.FINISHED);

        Intern updatedIntern = internRepository.save(savedIntern);

        Assertions.assertThat(updatedIntern.getEmail()).isNotNull();
        Assertions.assertThat(updatedIntern.getInternStatus()).isNotNull();

    }

    @Test
    public void InternRepository_DeleteIntern_ReturnInternIsEmpty(){
        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Smith")
                .email("johnsmith@gmail.com")
                .phoneNumber("996777564534")
                .stackId(1L)
                .mentorId(1L)
                .paymentCost(10000)
                .internStatus(InternStatus.PENDING)
                .build();
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));


        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));


        Intern intern = internRepository.save(InternMapper.toDto(internRequest, mentor, stack));


        internRepository.deleteById(intern.getId());

        Optional<Intern> internReturn = internRepository.findById(intern.getId());

        Assertions.assertThat(internReturn).isEmpty();

    }
}
