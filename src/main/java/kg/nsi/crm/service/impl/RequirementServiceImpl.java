package kg.nsi.crm.service.impl;

import java.lang.annotation.Annotation;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.mapper.RequirementMapper;
import kg.nsi.crm.repository.RequirementRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.results.DataResult;
import kg.nsi.crm.results.SuccessDataResult;
import kg.nsi.crm.service.RequirementService;
import kg.nsi.crm.service.StackService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequirementServiceImpl implements RequirementService{
	
	 final RequirementRepository requirementRepository;
	 final StackRepository stackRepository;
	 final StackService stackService;
	
	@Override
	public DataResult<Requirement> addRequirement(RequirementDto request) {
		
		Stack stack = stackService.getStackEntityById(request.getStackId());
		
		Requirement requirement = Requirement.builder()
				.name(request.getName())
				.stack(stack)
				.build();
		
		requirementRepository.save(requirement);
		return new SuccessDataResult<>("Requirement added!",requirementRepository.save(requirement));	
	}

	@Override
	public RequirementDto getRequirementEntityById(Long requirementId) {
		return RequirementMapper.toDto(requirementRepository.findById(requirementId).orElseThrow(RuntimeException::new));
		
	}

}

