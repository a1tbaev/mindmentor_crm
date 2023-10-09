package kg.nsi.crm.service;

import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.StackResponse;
import kg.nsi.crm.entity.Stack;

import java.util.List;

public interface StackService {

	SimpleResponse createStack(Stack stack);
	Stack getStackEntityById(Long stackId);

	List<StackResponse> getAll();
}
