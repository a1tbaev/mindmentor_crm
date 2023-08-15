package kg.nsi.crm.service;

import kg.nsi.crm.dto.InternRequirementDto;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.InternRequirement;

public interface InternRequirementService {

	SimpleResponse addInternRequirement(InternRequirementDto internRequirement);
	
}
