package kg.nsi.crm.service;

import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Stack;

public interface StackService {

	SimpleResponse createStack(Stack stack);
	Stack getStackEntityById(Long stackId);
}
