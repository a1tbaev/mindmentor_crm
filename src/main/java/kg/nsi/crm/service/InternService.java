package kg.nsi.crm.service;

import java.util.List;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.results.DataResult;
import kg.nsi.crm.results.Result;

public interface InternService {
	
	DataResult<InternDto> createIntern(InternDto intern);
	DataResult<InternDto> getInternById(Long id);
	InternDto getInternEntityById(Long id);
	DataResult<List<InternDto>> getAll();
	Result deleteInternById(Long id);
	DataResult<InternDto> updateIntern(InternDto intern);
}
