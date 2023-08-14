package kg.nsi.crm.service;

import kg.nsi.crm.dto.InternRequirementDto;
import kg.nsi.crm.entity.InternRequirement;
import kg.nsi.crm.results.Result;

public interface InternRequirementService {

	Result addInternRequirement(InternRequirementDto internRequirement);
	
}
