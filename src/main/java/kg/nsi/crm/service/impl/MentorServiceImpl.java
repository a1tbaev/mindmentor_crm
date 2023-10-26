package kg.nsi.crm.service.impl;

import jakarta.transaction.Transactional;
import kg.nsi.crm.dto.ExperienceDto;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.MentorUpdRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.dto.response.MentorResponse;
import kg.nsi.crm.dto.response.MentorResponse2;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.MentorMapper;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MentorServiceImpl implements MentorService {
    private final StackRepository stackRepository;
    private final MentorRepository mentorRepository;
    private final InternRepository internRepository;
    private final PdfParserService pdfParserService;

    @Override //save button
    public SimpleResponse saveExtractedDataFromCv(
            @NotNull MentorRequest mentorRequest,
            MultipartFile file) {
        List<Mentor> mentors = mentorRepository.findAll();

        for(Mentor mentor: mentors){
            if(mentor.getEmail().equals(mentorRequest.getEmail())){
                return new SimpleResponse("The mentor with this email already exists!", HttpStatus.BAD_REQUEST);
            }
        }
        ExtractedDataDto extractedDataDto =  pdfParserService.parse(file);
        System.out.println(extractedDataDto.getExperience());

        Set<Stack> set = new HashSet<>();

        if(mentorRequest.getStackIds() != null) {
            for (Long id : mentorRequest.getStackIds()) {
                set.add(stackRepository.getById(id));
            }
        }
        

        String education = "";
        if(extractedDataDto.getEducation() != null) {
            for (String ed : extractedDataDto.getEducation()) {
                education = education + ed + System.lineSeparator();
            }
        }
        String experience = "";
        if(extractedDataDto.getExperience() != null) {

            for (ExperienceDto exp : extractedDataDto.getExperience()) {

                experience = experience + " " + exp.getJobTitle() + " "
                        + exp.getCompany() + " " + exp.getDescription()
                        + " " + exp.getLocation() + System.lineSeparator();
            }
        }

        String skills = "";
        if(extractedDataDto.getStack() != null) {
            for (String skill : extractedDataDto.getStack()) {

                skills = skills + skill + System.lineSeparator();
            }
        }

        Mentor mentor = Mentor.builder()
                .firstName(mentorRequest.getFirstName())
                .lastName(mentorRequest.getLastName())
                .email(mentorRequest.getEmail())
                .isBillable(mentorRequest.getIsBillable())
                .education(education)
                .experience(experience)
                .stacks(set)
                .skills(skills)
                .phoneNumber(mentorRequest.getPhoneNumber())
                .build();

        mentorRepository.save(mentor);
        return new SimpleResponse("The mentor saved succesfully", HttpStatus.OK);
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
    public SimpleResponse updateMentor(Long id, MentorUpdRequest newMentor) {

        Mentor oldMentor = mentorRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s not found!", id)));



        if (newMentor.getFirstname() != null) oldMentor.setFirstName(newMentor.getFirstname());
        if (newMentor.getLastname() != null) oldMentor.setLastName(newMentor.getLastname());
        if (newMentor.getEmail() != null) oldMentor.setEmail(newMentor.getEmail());
        if(newMentor.isBillable()){
            oldMentor.setIsBillable(true);
        }
        else {
            oldMentor.setIsBillable(false);
        }
        if(newMentor.getExperience() != null) oldMentor.setExperience(newMentor.getExperience());
        if(newMentor.getEducation() != null) oldMentor.setEducation(newMentor.getEducation());

        if(newMentor.getSkills() != null) oldMentor.setSkills(newMentor.getSkills());

        if(newMentor.getStackIds() != null)
        {
            HashSet<Stack> set = new HashSet<>();
            for(Long stackId: newMentor.getStackIds()){
                set.add(stackRepository.getById(stackId));
            }
            oldMentor.setStacks(set);
        }

        mentorRepository.save(oldMentor);
        return new SimpleResponse("The mentor successfully updated!", HttpStatus.OK);
    }

    @Override
    public MentorResponse getMentor(Long mentorId) {
        Mentor mentor = mentorRepository.getById(mentorId);
        return MentorMapper.toResponse(mentor);

    }

    @Override
    public List<MentorResponse> getAll() {
        List<Mentor> mentors = mentorRepository.findAll();
        List<MentorResponse> mentorResponses = new ArrayList<>();

        for(Mentor mentor: mentors){
            mentorResponses.add(MentorMapper.toResponse(mentor));
        }
        return mentorResponses;
    }


    @Override
    public List<MentorResponse2> findAll() {
        List<Mentor> mentors = mentorRepository.findAll();
        List<MentorResponse2> mentorResponses = new ArrayList<>();

        for(Mentor mentor: mentors){
            mentorResponses.add(MentorMapper.toResponse2(mentor));
        }
        return mentorResponses;
    }

    @Override
    public MentorResponse findByEmail(String email) {
        Mentor mentor = mentorRepository.findByEmail(email)
                .orElseThrow(()-> new NotFoundException("mentor not found with email " + email));
        return MentorMapper.toResponse(mentor);
    }
}
