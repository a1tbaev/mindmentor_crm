package kg.nsi.crm.service;

import java.util.List;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.data.domain.PageRequest;

public interface InternService {
	
	SimpleResponse createIntern(InternDto intern);
	InternDto getInternById(Long id);
	InternDto getInternEntityById(Long id);
	//List<InternDto> getAll();
	SimpleResponse deleteInternById(Long id);
	SimpleResponse updateIntern(InternDto intern);

    List<InternDto> getAll(PageRequest pageRequest);
}
