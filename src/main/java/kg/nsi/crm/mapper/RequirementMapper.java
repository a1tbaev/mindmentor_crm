package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.StackService;
import kg.nsi.crm.service.impl.StackServiceImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequirementMapper {

	private final StackService stackService;

	public RequirementDto toDto(Requirement requirement) {
		return RequirementDto.builder()
				.name(requirement.getName())
				.stackId(requirement.getStack().getId())
				.build();
		
		
	}

	public Requirement toEntity(RequirementDto requirementDto) {
		return Requirement.builder()
				.name(requirementDto.getName())
				.stack(stackService.getStackEntityById(requirementDto.getStackId()))
				.build();
	}
}
