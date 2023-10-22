package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.MentorUpdRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.dto.response.MentorResponse;
import kg.nsi.crm.dto.response.MentorResponse2;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface MentorService {
    SimpleResponse saveExtractedDataFromCv(MentorRequest mentorRequest, MultipartFile file);
    SimpleResponse deleteMentor(Long mentorId);
    SimpleResponse updateMentor(Long id, MentorUpdRequest newMentor);

    MentorResponse getMentor(Long mentorId);

    List<MentorResponse> getAll();
    List<MentorResponse2> findAll();
    MentorResponse findByEmail(String email);
}
