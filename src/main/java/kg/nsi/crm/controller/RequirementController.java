package kg.nsi.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.dto.request.AddRequirementRequest;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.service.impl.InternServiceImpl;
import kg.nsi.crm.service.impl.RequirementServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requirements")
public class RequirementController {
	
	@Autowired
	RequirementServiceImpl requirementServiceImpl;

	@PostMapping("/createRequirement")
	public ResponseEntity<String> addRequirement(@RequestBody AddRequirementRequest requirement){
		this.requirementServiceImpl.addRequirement(requirement);
		return ResponseEntity.ok("Requirement created successfully!");
	}
}
