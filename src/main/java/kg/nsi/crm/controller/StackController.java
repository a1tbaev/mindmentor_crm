package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.StackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.service.impl.StackServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stack")
@RequiredArgsConstructor
@Tag(name = "Stack", description = "The Stack API")
public class StackController {
	
	private final StackServiceImpl stackService;

	@Operation(summary = "Create a new stack", description = "This method to create a new stack")
	@PostMapping("/")
	public SimpleResponse createStack(@RequestBody Stack stack){
		return stackService.createStack(stack);

	}
	@Operation(summary = "Get all the stacks", description = "This method is to get all stacks")
	@GetMapping("/")
	public List<StackResponse> getAll(){
		return stackService.getAll();
	}
}
