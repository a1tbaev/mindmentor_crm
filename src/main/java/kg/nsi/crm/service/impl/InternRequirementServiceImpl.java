package kg.nsi.crm.service.impl;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.repository.RequirementRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.InternRequirementDto;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.InternRequirement;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.InternRequirementRepository;
import kg.nsi.crm.service.InternRequirementService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InternRequirementServiceImpl implements InternRequirementService{
	private final InternRepository internRepository;
	private final RequirementRepository requirementRepository;
	private final InternRequirementRepository internRequirementRepository;
	@Override
	public SimpleResponse addInternRequirement(InternRequirementDto internRequirementDto) {

		Intern intern = internRepository.findById(internRequirementDto.getInternId()).orElseThrow(()-> new ExecutionException(""));

		Requirement requirement = requirementRepository.findById(internRequirementDto.getRequirementId()).orElseThrow(()-> new ExecutionException(""));

		InternRequirement internRequirement = new InternRequirement();

		internRequirement.setIntern(intern);
		internRequirement.setRequirement(requirement);
		internRequirement.setIsFinished(internRequirementDto.getIsFinished());

		internRequirementRepository.save(internRequirement);

		return new SimpleResponse( "The intern-requirement created successfully", HttpStatus.OK);

	}

}
