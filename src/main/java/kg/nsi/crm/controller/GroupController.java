package kg.nsi.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.entity.Group;
import kg.nsi.crm.service.impl.GroupServiceImpl;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
	
	@Autowired
	 GroupServiceImpl groupServiceImpl;
	
	@PostMapping("/addGroup")
	public ResponseEntity<Group> addGroup(@RequestBody Group group){
		return ResponseEntity.ok(this.groupServiceImpl.addGroup(group));
	}

}
