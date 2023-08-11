package kg.nsi.crm.service.impl;

import java.lang.annotation.Annotation;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.request.AddRequirementRequest;
import kg.nsi.crm.entity.Requirement;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.repository.RequirementRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.RequirementService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequirementServiceImpl implements RequirementService{
	
	@Autowired
	RequirementRepository repository;
	private final StackRepository stackRepository;
	
	@Override
	public Requirement addRequirement(AddRequirementRequest requirement) {
		Stack stack = null;
		try {
			stack = stackRepository.findById(requirement.getStackId()).orElseThrow(()-> new Exception());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Requirement requirement2 = new Requirement();
		requirement2.setName(requirement.getName());
		requirement2.setStack(stack);
		
		return this.repository.save(requirement2);
		
	}

}

