package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.StackResponse;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.StackMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.repository.StackRepository;

import kg.nsi.crm.service.StackService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StackServiceImpl implements StackService{
	private final StackRepository stackRepository;
	
	@Override
	public SimpleResponse createStack(Stack stack) {
		stackRepository.save(stack);
		return new SimpleResponse( "The stack created successfully", HttpStatus.OK);
	}

	@Override
	public Stack getStackEntityById(Long stackId) {
		return stackRepository.findById(stackId).orElseThrow(
				()-> new NotFoundException("Stack by "+stackId+" not found!"));
	}

	@Override
	public List<StackResponse> getAll() {
		List<Stack> stacks = stackRepository.findAll();

		List<StackResponse> stackResponses = new ArrayList<>();
		for(Stack stack: stacks){
			stackResponses.add(StackMapper.toResponse(stack));
		}
		return stackResponses;
	}


}
