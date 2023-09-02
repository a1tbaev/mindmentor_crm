package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.mapper.RequirementMapper;
import kg.nsi.crm.repository.RequirementRepository;

import kg.nsi.crm.service.RequirementService;
import kg.nsi.crm.service.StackService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequirementServiceImpl implements RequirementService{
	
	 private final RequirementRepository requirementRepository;
	 private final StackService stackService;
	 private  RequirementMapper requirementMapper;

	@Override
	public SimpleResponse addRequirement(RequirementDto request) {
		
		Stack stack = stackService.getStackEntityById(request.getStackId());
		
		Requirement requirement = Requirement.builder()
				.name(request.getName())
				.stack(stack)
				.build();
		
		requirementRepository.save(requirement);
		return new SimpleResponse( "The requirement created successfully", HttpStatus.OK);
	}

	@Override
	public RequirementDto getRequirementEntityById(Long requirementId) {
		return requirementMapper.toDto(requirementRepository.findById(requirementId).orElseThrow(RuntimeException::new));
		
	}

}

