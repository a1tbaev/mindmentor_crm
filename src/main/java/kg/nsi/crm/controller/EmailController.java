package kg.nsi.crm.controller;

import jakarta.mail.MessagingException;
import kg.nsi.crm.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/send")
    public void sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) throws MessagingException {
        emailService.sendEmail(to, subject, text);
    }
}
