package kg.nsi.crm.service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Group;

public interface GroupService {
	SimpleResponse addGroup(GroupDto group);
	Group getGroupEntityById(Long groupId);
}
