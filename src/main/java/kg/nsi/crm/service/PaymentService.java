package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.PaymentRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;

public interface PaymentService {
    SimpleResponse replenishment(PaymentRequest paymentRequest, Long internId);
    void processPayment(Intern intern);
}
