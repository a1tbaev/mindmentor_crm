package kg.nsi.crm.controller;

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
public class StackController {
	
	private final StackServiceImpl serviceImpl;
	
	@PostMapping("/")
	public SimpleResponse createStack(@RequestBody Stack stack){
		return serviceImpl.createStack(stack);

	}
}
