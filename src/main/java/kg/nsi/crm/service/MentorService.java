package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.SimpleResponse;

public interface MentorService {
    SimpleResponse createMentor(MentorRequest mentorRequest);
    SimpleResponse deleteMentor(Long mentorId);
}
