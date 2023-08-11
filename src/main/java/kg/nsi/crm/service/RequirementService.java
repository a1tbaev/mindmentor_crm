package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.AddRequirementRequest;
import kg.nsi.crm.entity.Requirement;

public interface RequirementService {

	Requirement addRequirement(AddRequirementRequest requirement);
}
