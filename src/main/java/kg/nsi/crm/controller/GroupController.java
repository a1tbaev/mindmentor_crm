package kg.nsi.crm.controller;


import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.GroupService;
import org.springframework.web.bind.annotation.*;
import kg.nsi.crm.dto.GroupDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {
	
	private final GroupService groupService;
	
	@PostMapping("/")
	public SimpleResponse addGroup(@RequestBody GroupRequest groupDto){
		return groupService.addGroup(groupDto);
	}

	@GetMapping("/{groupId}")
	public GroupDto getGroupEntityById(@PathVariable Long groupId){
		return groupService.getGroupEntityById(groupId);
	}

	@DeleteMapping("/{groupId}")
	SimpleResponse delete(@PathVariable Long groupId){
		return groupService.delete(groupId);
	}

	@PutMapping("/{groupId}")
	SimpleResponse update(@PathVariable Long groupId, @RequestBody GroupRequest groupRequest){
		return groupService.update(groupId, groupRequest);
	}
}
