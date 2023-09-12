package kg.nsi.crm.dto.response;

import lombok.Builder;

@Builder
public record VendorResponse (
        String name,
        String img,
        String email,
        String address,
        String phoneNumber
) {
}
