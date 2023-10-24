package kg.nsi.crm.dto.request;

import lombok.Builder;

@Builder
public record PaymentRequest(
        String cash
) {
}
