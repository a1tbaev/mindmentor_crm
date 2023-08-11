package kg.nsi.crm.service.impl;

import org.springframework.stereotype.Service;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.repository.UserRepository;
import kg.nsi.crm.service.StackService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StackServiceImpl implements StackService{
	final StackRepository stackRepository;
	
	@Override
	public Stack createStack(Stack stack) {
		return stackRepository.save(stack);
	}

}
