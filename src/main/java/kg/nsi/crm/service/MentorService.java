package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface MentorService {
    ExtractedDataDto getExtractedDataFromCv(MentorRequest mentorRequest, MultipartFile file);
    SimpleResponse deleteMentor(Long mentorId);
    SimpleResponse updateMentor(Long id, MentorRequest newMentor);

    SimpleResponse createMentor(UpdatedMentorRequest updatedMentorRequest);
}
