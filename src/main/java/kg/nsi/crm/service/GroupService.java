package kg.nsi.crm.service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.EventResponse;
import kg.nsi.crm.dto.response.SimpleResponse;

import java.util.List;

public interface GroupService {
	SimpleResponse addGroup(GroupRequest group);
	GroupDto getGroupEntityById(Long groupId);
	SimpleResponse delete(Long groupId);
	SimpleResponse update(Long groupId, GroupRequest groupRequest);

	List<GroupDto> getAll();

	List<EventResponse> getAllEvents(Long groupId);
}
