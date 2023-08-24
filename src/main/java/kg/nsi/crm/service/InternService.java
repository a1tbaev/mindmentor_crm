package kg.nsi.crm.service;

import java.util.List;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface InternService {
	
	SimpleResponse createIntern(InternRequest internRequest) throws ChangeSetPersister.NotFoundException;
	InternDto getInternById(Long id);
	InternDto getInternEntityById(Long id);
	List<InternDto> getAll();
	SimpleResponse deleteInternById(Long id);
	SimpleResponse updateIntern(InternDto intern);
}
