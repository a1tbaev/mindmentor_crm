package kg.nsi.crm.controller;

import kg.nsi.crm.dto.request.PaymentRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{internId}")
    public SimpleResponse replenishment(@RequestParam String cash, @PathVariable Long internId){
        return paymentService.replenishment(cash, internId);
    }

}
