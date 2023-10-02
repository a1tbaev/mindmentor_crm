package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.InterviewRequest;
import kg.nsi.crm.dto.response.SimpleResponse;

public interface InterviewService {
    SimpleResponse save(InterviewRequest interviewRequest);
}
