package kg.nsi.crm.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
