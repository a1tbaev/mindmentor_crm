package kg.nsi.crm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.dto.RequirementDto;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.results.DataResult;
import kg.nsi.crm.service.impl.RequirementServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requirements")
public class RequirementController {
	
	final RequirementServiceImpl requirementServiceImpl;

	@PostMapping("/")
	public DataResult<Requirement> addRequirement(@RequestBody RequirementDto requirement){
		return requirementServiceImpl.addRequirement(requirement);
		
	}
}
