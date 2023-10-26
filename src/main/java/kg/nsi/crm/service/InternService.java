package kg.nsi.crm.service;

import java.util.List;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.InternResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.enums.InternStatus;
import org.springframework.data.domain.PageRequest;

public interface InternService {
	
	SimpleResponse createIntern(InternRequest internRequest);
	InternDto getInternById(Long id);
	InternDto getInternEntityById(Long id);
	List<InternResponse> getAll(PageRequest pageRequest);
	SimpleResponse deleteInternById(Long id);
	SimpleResponse updateIntern(InternRequest internRequest, Long id);
	List<InternResponse> getInternsByName(String name);

	List<InternResponse> getInternsByStatus(InternStatus status);

}
