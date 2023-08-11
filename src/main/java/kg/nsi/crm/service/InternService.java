package kg.nsi.crm.service;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Intern;

public interface InternService {
	
	Intern createAccount(InternDto intern);
	Intern getInternById(Long id);
	Intern getInternEntityById(Long id);
	
	void deleteInternById(Long id);
	Intern updateIntern(InternDto intern);
}
