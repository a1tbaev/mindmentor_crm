package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.VacancyResponse;
import kg.nsi.crm.enums.DeveloperLevel;
import kg.nsi.crm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<VacancyResponse> getAllVacancyByVendorId(Long vendorId) {
        String sql  = """
                SELECT s.name as stack_name,
                       v.level as level ,
                       v.release_day as dates
                FROM vacancy v JOIN stacks s on s.id = v.stack_id
                """;
        sql+=" where v.vendor_id = "+vendorId;
        return jdbcTemplate.query(sql,(resultSet,i)->VacancyResponse.builder()
                .stackName(resultSet.getString("stack_name"))
                .date(resultSet.getDate("dates").toLocalDate())
                .level(DeveloperLevel.valueOf(resultSet.getString("level")))
                .build());
    }
}
