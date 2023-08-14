package kg.nsi.crm.service.impl;

import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.InternRequirementDto;
import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.InternRequirement;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.mapper.InternMapper;
import kg.nsi.crm.mapper.InternRequirementMapper;
import kg.nsi.crm.mapper.RequirementMapper;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.InternRequirementRepository;
import kg.nsi.crm.results.Result;
import kg.nsi.crm.results.SuccessDataResult;
import kg.nsi.crm.service.GroupService;
import kg.nsi.crm.service.InternRequirementService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InternRequirementServiceImpl implements InternRequirementService{
	
	final InternRequirementRepository internRequirementRepository;
	final InternServiceImpl internServiceImpl;
	final RequirementServiceImpl requirementServiceImpl;
	final GroupServiceImpl groupServiceImpl;
	@Override
	public Result addInternRequirement(InternRequirementDto internRequirementDto) {
		
		InternDto internDto = internServiceImpl.getInternEntityById(internRequirementDto.getInternId());
		Group group = groupServiceImpl.getGroupEntityById(internDto.getGroupId());
		
		Intern intern = InternMapper.toDto(internServiceImpl.getInternEntityById(internRequirementDto.getInternId()),group);
		RequirementDto requirementDto =  requirementServiceImpl.getRequirementEntityById(internRequirementDto.getRequirementId());
				
		Boolean isFinished = internRequirementDto.getIsFinished();
		
		InternRequirement internRequirement = new InternRequirement();
		internRequirement.setIntern(intern);
		internRequirement.setRequirement(RequirementMapper.toEntity(requirementDto));
		internRequirement.setIsFinished(isFinished);
		
		internRequirementRepository.save(internRequirement);
		return new SuccessDataResult<>("InternRequirement created",internRequirement);
	}

}
