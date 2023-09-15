package kg.nsi.crm.service.impl;

import
        jakarta.transaction.Transactional;
import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
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

import java.io.File;
import java.time.LocalDate;
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

    @Override
    public ExtractedDataDto getExtractedDataFromCv(@NotNull MentorRequest mentorRequest, MultipartFile file) {

        ExtractedDataDto extractedDataDto =  pdfParserService.parse(file);

        extractedDataDto.setFirstName(mentorRequest.firstName());
        extractedDataDto.setLastName(mentorRequest.lastName());

        List<Stack> mentorStacks = stackRepository.findAll();
        Set<String> stackNames = new HashSet<>();

        ArrayList<String> sNames = new ArrayList<>();

        for(Stack stack: mentorStacks){
            stackNames.add(stack.getName());
        }

        Set<Stack> stacks = new HashSet<>();
        for(String stack: extractedDataDto.getStack()){
            for(String stackName: stackNames){
                if(stack.toUpperCase().contains(stackName.toUpperCase())){
                    mentorStacks.add(stackRepository.findByName(stack));
                    if(!sNames.contains(stackName)) sNames.add(stackName);
                }

            }
        }
        extractedDataDto.setStack(sNames);
        return extractedDataDto;
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
        if (newMentor.isBillable() != null) oldMentor.setIsBillable(newMentor.isBillable());
        //method(newMentor.stackIDies(),oldMentor);
        mentorRepository.save(oldMentor);
        return new SimpleResponse("The mentor successfully updated!", HttpStatus.OK);
    }

    @Override
    public SimpleResponse createMentor(UpdatedMentorRequest updatedMentorRequest) {
            Mentor mentor = MentorMapper.toEntity(updatedMentorRequest);
            Set<Stack> stacks = new HashSet<>();

            for(String name: updatedMentorRequest.stacks()){
                stacks.add(stackRepository.findByName(name));
            }


            mentor.setStacks(stacks);

            mentorRepository.save(mentor);
        return new SimpleResponse("The mentor is created!", HttpStatus.OK);
    }
}
