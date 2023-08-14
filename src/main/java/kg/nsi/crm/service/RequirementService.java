package kg.nsi.crm.service;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.results.Result;

public interface RequirementService {

	Result addRequirement(RequirementDto request);
	RequirementDto getRequirementEntityById(Long requirementId);
	
}
