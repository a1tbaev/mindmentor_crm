package kg.nsi.crm.repository;

import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.mapper.MentorMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MentorRepositoryTests {

    @Autowired
    private MentorRepository mentorRepository;


    @Test
    public void MentorRepository_CreateMentor_ReturnMentor(){
        Set<String> stacks = new HashSet<>();
        stacks.add("Java");
        stacks.add("python");


        UpdatedMentorRequest updatedMentorRequest = UpdatedMentorRequest.builder()
                .firstName("Charlie")
                .lastName("Puth")
                .email("charliep@gmail.com")
                .education("Hong Kong University")
                .experience("Deliver cybersecurity consulting services to industry and government clients valued at $5M-$10M," +
                        " monitor networks for security breaches," +
                        " and identify opportunities to enhance data security protocols and threat prevention")
                .isBillable(true)
                .stacks(stacks)
                .build();


        Mentor mentor = mentorRepository.save(MentorMapper.toEntity(updatedMentorRequest));

        //Assert
        Assertions.assertThat(mentor).isNotNull();
        Assertions.assertThat(mentor.getId()).isGreaterThan(0);
    }

    @Test
    public void MentorRepository_FindMentorById_ReturnMentor(){
        Set<String> stacks = new HashSet<>();
        stacks.add("Java");
        stacks.add("python");


        UpdatedMentorRequest updatedMentorRequest = UpdatedMentorRequest.builder()
                .firstName("Charlie")
                .lastName("Puth")
                .email("charliep@gmail.com")
                .education("Hong Kong University")
                .experience("Deliver cyber security consulting services to industry and government clients valued at $5M-$10M," +
                        " monitor networks for security breaches," +
                        " and identify opportunities to enhance data security protocols and threat prevention")
                .isBillable(true)
                .stacks(stacks)
                .build();


        Mentor savedMentor = mentorRepository.save(MentorMapper.toEntity(updatedMentorRequest));


        Optional<Mentor> mentor = mentorRepository.findById(savedMentor.getId());

        //Assert
        Assertions.assertThat(mentor).isNotNull();

    }

    @Test
    public void MentorRepository_GetAll_ReturnMoreThanOne(){

        Set<String> stacks = new HashSet<>();
        stacks.add("Java");
        stacks.add("python");


        UpdatedMentorRequest updatedMentorRequest = UpdatedMentorRequest.builder()
                .firstName("Charlie")
                .lastName("Puth")
                .email("charliep@gmail.com")
                .education("Hong Kong University")
                .experience("Deliver cyber security consulting services to industry and government clients valued at $5M-$10M," +
                        " monitor networks for security breaches," +
                        " and identify opportunities to enhance data security protocols and threat prevention")
                .isBillable(true)
                .stacks(stacks)
                .build();

        UpdatedMentorRequest updatedMentorRequest2 = UpdatedMentorRequest.builder()
                .firstName("Maria")
                .lastName("Canberra")
                .email("maria@gmail.com")
                .education("Hong Kong University")
                .experience("Deliver cyber security consulting services to industry and government clients valued at $5M-$10M," +
                        " monitor networks for security breaches," +
                        " and identify opportunities to enhance data security protocols and threat prevention")
                .isBillable(true)
                .stacks(stacks)
                .build();

        mentorRepository.save(MentorMapper.toEntity(updatedMentorRequest));
        mentorRepository.save(MentorMapper.toEntity(updatedMentorRequest2));


        List<Mentor> mentors =  mentorRepository.findAll();

        Assertions.assertThat(mentors).isNotNull();
        Assertions.assertThat(mentors.size()).isGreaterThan(2);

    }

    @Test
    public void MentorRepository_UpdateMentor_ReturnMentorNotNull(){
        Set<String> stacks = new HashSet<>();
        stacks.add("Java");
        stacks.add("python");


        UpdatedMentorRequest updatedMentorRequest = UpdatedMentorRequest.builder()
                .firstName("Charlie")
                .lastName("Puth")
                .email("charliep@gmail.com")
                .education("Hong Kong University")
                .experience("Deliver cyber security consulting services to industry and government clients valued at $5M-$10M," +
                        " monitor networks for security breaches," +
                        " and identify opportunities to enhance data security protocols and threat prevention")
                .isBillable(true)
                .stacks(stacks)
                .build();

        Mentor mentor = mentorRepository.save(MentorMapper.toEntity(updatedMentorRequest));

        Optional<Mentor> savedMentor = mentorRepository.findById(mentor.getId());
        savedMentor.get().setEmail("charlieputh@gmail.com");
        savedMentor.get().setIsBillable(false);

        Mentor updatedMentor = mentorRepository.save(savedMentor.get());

        Assertions.assertThat(updatedMentor.getEmail()).isNotNull();
        Assertions.assertThat(updatedMentor.getIsBillable()).isNotNull();
    }


}
