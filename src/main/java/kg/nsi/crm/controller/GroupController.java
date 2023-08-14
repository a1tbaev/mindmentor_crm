package kg.nsi.crm.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.results.Result;
import kg.nsi.crm.service.impl.GroupServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {
	
	 final GroupServiceImpl groupServiceImpl;
	
	@PostMapping("/")
	public Result addGroup(@RequestBody GroupDto groupDto){
		return groupServiceImpl.addGroup(groupDto);
	}

}
