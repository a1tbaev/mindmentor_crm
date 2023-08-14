package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.service.impl.StackServiceImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequirementMapper {
	
	static final StackServiceImpl stackServiceImpl = null;

	public static RequirementDto toDto(Requirement requirement) {
		return RequirementDto.builder()
				.name(requirement.getName())
				.stackId(requirement.getStack().getId())
				.build();
		
		
	}

	public static Requirement toEntity(RequirementDto requirementDto) {
		return Requirement.builder()
				.name(requirementDto.getName())
				.stack(stackServiceImpl.getStackEntityById(requirementDto.getStackId()))
				.build();
	}
}
