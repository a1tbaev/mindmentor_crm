package kg.nsi.crm.controller;

import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.dto.RequirementDto;

import kg.nsi.crm.service.impl.RequirementServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requirements")
public class RequirementController {
	
	private final RequirementServiceImpl requirementServiceImpl;

	@PostMapping("/")
	public SimpleResponse addRequirement(@RequestBody RequirementDto requirement){
		return requirementServiceImpl.addRequirement(requirement);
		
	}
}
