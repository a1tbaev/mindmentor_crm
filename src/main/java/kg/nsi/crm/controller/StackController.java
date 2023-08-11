package kg.nsi.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.service.impl.StackServiceImpl;

@RestController
@RequestMapping("/api/v1/stack")
public class StackController {
	
	@Autowired
	 StackServiceImpl serviceImpl;
	
	@PostMapping("/createStack")
	public ResponseEntity<String> createStack(@RequestBody Stack stack){
		serviceImpl.createStack(stack);
		return ResponseEntity.ok("Stack created successfully!");
	}
}
