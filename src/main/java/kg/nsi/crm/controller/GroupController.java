package kg.nsi.crm.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.GroupService;
import org.springframework.web.bind.annotation.*;
import kg.nsi.crm.dto.GroupDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/groups")
@Tag(name = "Group", description = "The Group API")
@RequiredArgsConstructor
public class GroupController {
	
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
}
