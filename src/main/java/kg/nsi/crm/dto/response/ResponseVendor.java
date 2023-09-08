package kg.nsi.crm.dto.response;

import lombok.Builder;

import java.util.List;
@Builder
public record ResponseVendor(
        String name,
        String img,
        String email,
        String address,
        String phoneNumber,
        String information,
        List<VacancyResponse>vacancy
) {
}
