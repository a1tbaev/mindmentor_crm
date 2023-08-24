package kg.nsi.crm.controller;


import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.web.bind.annotation.*;
import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.service.impl.GroupServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {
	
	 final GroupServiceImpl groupServiceImpl;
	
	@PostMapping("/")
	public SimpleResponse addGroup(@RequestBody GroupRequest groupDto){
		return groupServiceImpl.addGroup(groupDto);
	}

	@GetMapping("{groupId}")
	public GroupDto getGroupEntityById(@PathVariable Long groupId){
		return groupServiceImpl.getGroupEntityById(groupId);
	}
}
