package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.VacancyResponse;
import kg.nsi.crm.enums.DeveloperLevel;
import kg.nsi.crm.repository.custom.VacancyCustom;
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
        return jdbcTemplate.query(new VacancyCustom().getAllVacancyByVendorIdQuery(vendorId),
                (resultSet, i) -> VacancyResponse.builder()
                .stackName(resultSet.getString("stack_name"))
                .date(resultSet.getDate("dates").toLocalDate())
                .level(DeveloperLevel.valueOf(resultSet.getString("level")))
                .build());
    }
}
