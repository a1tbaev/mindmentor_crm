package kg.nsi.crm.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.EventResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.enums.GroupStatus;
import kg.nsi.crm.service.GroupService;
import org.springframework.web.bind.annotation.*;
import kg.nsi.crm.dto.GroupDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@Tag(name = "Group", description = "The Group API")
@RequiredArgsConstructor
public class  GroupController {
	
	private final GroupService groupService;

	@Operation(summary = "Create a new group", description = "This method to create a new group")
	@PostMapping("/")
	public SimpleResponse addGroup(@RequestBody GroupRequest groupDto){
		return groupService.addGroup(groupDto);
	}

	@Operation(summary = "Get the group by id", description = "This method to get the group")
	@GetMapping("/{groupId}")
	public GroupDto getGroupEntityById(@PathVariable Long groupId){
		return groupService.getGroupEntityById(groupId);
	}

	@Operation(summary = "Delete the group by id", description = "This method to delete the group")
	@DeleteMapping("/{groupId}")
	SimpleResponse delete(@PathVariable Long groupId){
		return groupService.delete(groupId);
	}

	@Operation(summary = "Update the group information", description = "This method to update the group information")
	@PutMapping("/{groupId}")
	SimpleResponse update(@PathVariable Long groupId, @RequestBody GroupRequest groupRequest){
		return groupService.update(groupId, groupRequest);
	}
	@Operation(summary = "Get all the groups", description = "This method is to get all the groups --select INACTIVE,\n" +
															 "    ACTIVE,\n" +
															 "    FINISHED")
	@GetMapping("/")
	public List<GroupDto> getAll(){
		return groupService.getAll();
	}

	@Operation(summary = "Get group's all the events", description = "Get group's all the events")
	@GetMapping("/events/{groupId}")
	List<EventResponse> getAllEvents(@RequestParam Long groupId){
		return groupService.getAllEvents(groupId);
	}

	@Operation(summary = "Get all group status")
	@GetMapping("/get_all_group_status")
	public GroupStatus[] getAllGroupStatus(){
		return GroupStatus.values();
	}
}
