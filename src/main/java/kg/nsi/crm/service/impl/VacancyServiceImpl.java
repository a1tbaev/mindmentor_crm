package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.request.VacancyRequest;
import kg.nsi.crm.dto.response.ResponseVacancy;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.VacancyResponse;
import kg.nsi.crm.entity.Vacancy;
import kg.nsi.crm.entity.Vendor;
import kg.nsi.crm.enums.DeveloperLevel;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.repository.VacancyRepository;
import kg.nsi.crm.repository.VendorRepository;
import kg.nsi.crm.repository.custom.VacancyCustom;
import kg.nsi.crm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final JdbcTemplate jdbcTemplate;
    private final VendorRepository vendorRepository;
    private final VacancyRepository vacancyRepository;

    @Override
    public List<VacancyResponse> getAllVacancyByVendorId(Long vendorId) {
        return jdbcTemplate.query(new VacancyCustom().getAllVacancyByVendorIdQuery(vendorId),
                (resultSet, i) -> VacancyResponse.builder()
                        .stackName(resultSet.getString("stack_name"))
                        .date(resultSet.getDate("dates").toLocalDate())
                        .level(DeveloperLevel.valueOf(resultSet.getString("level")))
                        .build());
    }

    @Override
    public SimpleResponse saveVacancy(VacancyRequest request) {
        Vendor vendor = vendorRepository.findById(request.companyId()).orElseThrow(
                () -> new NotFoundException("Vendor by id " + request.companyId() + " not found!"));
        vacancyRepository.save(Vacancy.builder()
                        .vacancyName(request.vacancyName())
                        .releaseDay(LocalDate.now())
                        .requirements(request.requirement())
                        .level(DeveloperLevel.valueOf(request.level()))
                        .vendor(vendor)
                        .build());
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The vacancy created successfully")
                .build();
    }

    @Override
    public ResponseVacancy getById(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Vacancy by id " + id + " not found!"));
        return ResponseVacancy.builder()
                .vacancyName(vacancy.getVacancyName())
                .developerLevel(vacancy.getLevel().name())
                .requirement(vacancy.getRequirements())
                .date(vacancy.getReleaseDay())
                .build();
    }

    @Override
    public SimpleResponse deleteVacancy(Long id) {
        vacancyRepository.delete(vacancyRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Vacancy by id " + id + " not found!")));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The vacancy deleted successfully")
                .build();
    }

    @Override
    public List<ResponseVacancy> getAllByVendorId(Long vendorId) {
        List<Vacancy> responseVacancies = vacancyRepository.findAllByVendorId(vendorId);
        List<ResponseVacancy> vacancyResponses = new ArrayList<>();
        if (responseVacancies.isEmpty()) {
            throw new NotFoundException("Vacancy by vendor id " + vendorId + " not found!");
        }

        else{
            for (Vacancy vacancy : responseVacancies) {
                vacancyResponses.add(ResponseVacancy.builder()
                        .vacancyName(vacancy.getVacancyName())
                        .developerLevel(vacancy.getLevel().name())
                        .requirement(vacancy.getRequirements())
                        .date(vacancy.getReleaseDay())
                        .build());
            }
            return vacancyResponses;
        }

    }
}
