package kg.nsi.crm.service.impl;

import jakarta.transaction.Transactional;
import kg.nsi.crm.dto.request.PaymentRequest;
import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final InternRepository internRepository;
    private final HistoryGeneratorServiceImpl historyGeneratorService;

    @Override
    public SimpleResponse replenishment(PaymentRequest paymentRequest, Long internId) {
        Intern intern = internRepository.findById(internId).orElseThrow();

        intern.setBalance(intern.getBalance() + paymentRequest.cash());

        processPayment(intern);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The payment was successful!!")
                .build();
    }

    @Override
    public void processPayment(Intern intern) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = intern.getGroup().getStartDate();
        LocalDate finishDate = intern.getGroup().getFinishDate();

        Period oneMonth = Period.ofMonths(1);
        LocalDate nextMonthStartDate = startDate.plus(oneMonth);

        if (currentDate.isBefore(nextMonthStartDate)) {
            if (!intern.getIsPaidForFirstMonth()) {
                intern.setBalance(intern.getBalance() - intern.getPaymentCoastPerMonth());
                if (intern.getBalance() > 0){
                    intern.setIsPaidForFirstMonth(true);
                    historyGeneratorService.forSave(HistoryResponse.builder()
                            .message("Status changed from unpaid to paid for the first month")
                            .build(), intern.getId());
                }
            }
        } else if (nextMonthStartDate.isAfter(currentDate) && nextMonthStartDate.isBefore(finishDate)) {
            if (!intern.getIsPaidForThirdMonth()) {
                intern.setBalance(intern.getBalance() - intern.getPaymentCoastPerMonth());
                if (intern.getBalance() >= 0){
                    intern.setIsPaidForThirdMonth(true);
                    historyGeneratorService.forSave(HistoryResponse.builder()
                            .message("Status changed from unpaid to paid for the second month")
                            .build(), intern.getId());
                }
            }
        } else {
            if (!intern.getIsPaidForSecondMonth()) {
                intern.setBalance(intern.getBalance() - intern.getPaymentCoastPerMonth());
                if (intern.getBalance() >= 0){
                    intern.setIsPaidForSecondMonth(true);
                    historyGeneratorService.forSave(HistoryResponse.builder()
                            .message("Status changed from unpaid to paid for the third month")
                            .build(), intern.getId());
                }
            }
        }
    }

}
