package kg.nsi.crm.service;

import kg.nsi.crm.dto.response.ExtractedDataDto;
import org.springframework.web.multipart.MultipartFile;

public interface ParserService {
        ExtractedDataDto parse(MultipartFile file);
}
