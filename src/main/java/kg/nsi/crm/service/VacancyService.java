package kg.nsi.crm.service;

import kg.nsi.crm.dto.response.VacancyResponse;

import java.util.List;

public interface VacancyService {
    List<VacancyResponse>getAllVacancyByVendorId(Long vendorId);
}
