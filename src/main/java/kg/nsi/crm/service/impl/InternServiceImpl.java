package kg.nsi.crm.service.impl;

import java.util.List;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.InternResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.repository.MentorRepository;
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

    private final InternRepository internRepository;
    private final MentorRepository mentorRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public SimpleResponse createIntern(InternRequest internRequest) {

        Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow();

        internRepository.save(InternMapper.toDto(internRequest, mentor));
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
        String sql = """
                SELECT
                    i.first_name AS first_name,
                    i.last_name AS last_name,
                    g.name AS group_name,
                    s.name AS stack,
                    i.status AS status,
                    CONCAT(m.first_name,' ',m.last_name) AS mentor_name
                FROM interns i
                         LEFT JOIN groups g ON g.id = i.group_id
                         JOIN interns_requirements ir ON i.id = ir.intern_id
                         JOIN requirements r ON ir.requirement_id = r.id
                         JOIN stacks s ON s.id = r.stack_id
                         FULL JOIN mentors m ON m.id = i.mentor_id;
                """;

        return jdbcTemplate.query(sql, (resultSet, i)
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
        return InternMapper.toEntity(internRepository.findById(id).orElseThrow(RuntimeException::new));
    }

}
