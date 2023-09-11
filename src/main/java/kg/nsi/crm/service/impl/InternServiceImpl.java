package kg.nsi.crm.service.impl;

import java.util.List;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.InternResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.repository.custom.InternCustom;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
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
    final JdbcTemplate jdbcTemplate;
    final StackRepository stackRepository;

    @Override
    public SimpleResponse createIntern(InternRequest internRequest) {

        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow(
                () -> new NotFoundException(String.format("Mentor with id %s is not found!", internRequest.mentorId())));
        Stack stack = stackRepository.findById(internRequest.stackId()).orElseThrow(
                () -> new NotFoundException(String.format("Stack with id %s is not found!", internRequest.stackId())));

        internRepository.save(InternMapper.toDto(internRequest, mentor, stack));
        return new SimpleResponse("The intern created successfully", HttpStatus.OK);
    }

    @Override
    public InternDto getInternById(Long id) {
        return getInternEntityById(id);
    }

    @Override
    public SimpleResponse deleteInternById(Long id) {
        return new SimpleResponse("The intern deleted successfully", HttpStatus.OK);
    }

    @Override
    public SimpleResponse updateIntern(InternDto internRequest) {
        Intern intern = this.internRepository.getInternById(internRequest.getId());

        if (internRequest.getFirstName() != null) intern.setFirstName(internRequest.getFirstName());
        if (internRequest.getLastName() != null) intern.setLastName(internRequest.getLastName());
        if (internRequest.getEmail() != null) intern.setEmail(internRequest.getEmail());
        if (internRequest.getPhoneNumber() != null) intern.setPhoneNumber(internRequest.getPhoneNumber());
        if (internRequest.getIsPaid() != null) intern.setIsPaid(internRequest.getIsPaid());
        if (internRequest.getInternStatus() != null) intern.setInternStatus(internRequest.getInternStatus());
        if (internRequest.getUpdateDate() != null) intern.setUpdateDate(internRequest.getUpdateDate());

        internRepository.save(intern);
        return new SimpleResponse("The mentor updated successfully", HttpStatus.OK);
    }


    @Override
    public List<InternResponse> getAll(PageRequest pageRequest) {
        return jdbcTemplate.query(new InternCustom().getAllQuery(), (resultSet, i)
                -> new InternResponse(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("group_name"),
                resultSet.getString("stack"),
                InternStatus.valueOf(resultSet.getString("status")),
                resultSet.getString("mentor_name")
        ));
    }

    @Override
    public InternDto getInternEntityById(Long id) {
        System.out.println("inside getInternEntityById");
        return InternMapper.toEntity(internRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Intern with id %s is not found!", id))));
    }

}
