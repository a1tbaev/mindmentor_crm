package kg.nsi.crm.service;

import kg.nsi.crm.dto.InterviewResponse;
import kg.nsi.crm.dto.request.InterviewRequest;
import kg.nsi.crm.dto.response.SimpleResponse;

import java.util.List;

public interface InterviewService {
    SimpleResponse save(InterviewRequest interviewRequest);
    List<InterviewResponse> getAll();
    SimpleResponse delete(Long interviewId);
}
