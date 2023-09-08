package kg.nsi.crm.dto.request;

import kg.nsi.crm.validation.PhoneNumberValid;
import lombok.Builder;

@Builder
public record VendorRequest (
        String name,
        String img,
        String email,
        String address,
        @PhoneNumberValid
        String phoneNumber,
        String information
) {

}
