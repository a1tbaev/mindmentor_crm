package kg.nsi.crm.service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.SimpleResponse;

public interface GroupService {
	SimpleResponse addGroup(GroupRequest group);
	GroupDto getGroupEntityById(Long groupId);
}
