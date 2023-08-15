package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.InternRequirementDto;
import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.InternRequirement;
import kg.nsi.crm.entity.Requirement;

public class InternRequirementMapper {
	
	public static InternRequirementDto toDto(InternRequirement internRequirement) {
		return InternRequirementDto.builder()
				.internId(internRequirement.getIntern().getId())
				.requirementId(internRequirement.getRequirement().getId())
				.isFinished(internRequirement.getIsFinished())
				.build();
		
		
	}


}
