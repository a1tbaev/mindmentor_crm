package kg.nsi.crm.dto;

import kg.nsi.crm.dto.request.MentorRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MentorFileDTO implements Serializable {

    private MultipartFile multipartFile;
    private MentorRequest mentorRequest;
}
