package kg.nsi.crm.service.impl;

import org.springframework.stereotype.Service;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.repository.UserRepository;
import kg.nsi.crm.results.DataResult;
import kg.nsi.crm.results.SuccessDataResult;
import kg.nsi.crm.service.StackService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StackServiceImpl implements StackService{
	final StackRepository stackRepository;
	
	@Override
	public DataResult<Stack> createStack(Stack stack) {
		return new SuccessDataResult<>("Stack created!",stackRepository.save(stack));
	}

	@Override
	public Stack getStackEntityById(Long stackId) {
		return stackRepository.findById(stackId).orElseThrow(RuntimeException::new);
	}


}
