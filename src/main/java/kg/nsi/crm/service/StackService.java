package kg.nsi.crm.service;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.results.DataResult;

public interface StackService {

	DataResult<Stack> createStack(Stack stack);
	Stack getStackEntityById(Long stackId);
}
