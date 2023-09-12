package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.VacancyRequest;
import kg.nsi.crm.dto.response.ResponseVacancy;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.VacancyResponse;

import java.util.List;

public interface VacancyService {
    List<VacancyResponse>getAllVacancyByVendorId(Long vendorId);
    SimpleResponse saveVacancy(VacancyRequest request);
    ResponseVacancy getById(Long id);
    SimpleResponse deleteVacancy(Long id);
}
