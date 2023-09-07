package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.service.impl.StackServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stack")
@RequiredArgsConstructor
@Tag(name = "Stack", description = "The Stack API")
public class StackController {
	
	private final StackServiceImpl serviceImpl;

	@Operation(summary = "Create a new stack", description = "This method to create a new stack")
	@PostMapping("/")
	public SimpleResponse createStack(@RequestBody Stack stack){
		return serviceImpl.createStack(stack);

	}
}
