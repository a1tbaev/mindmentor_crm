package kg.nsi.crm.service;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.dto.response.SimpleResponse;

public interface RequirementService {

	SimpleResponse addRequirement(RequirementDto request);
	RequirementDto getRequirementEntityById(Long requirementId);
	
}
