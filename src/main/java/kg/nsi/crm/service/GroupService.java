package kg.nsi.crm.service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.results.Result;

public interface GroupService {
	Result addGroup(GroupDto group);	
	Group getGroupEntityById(Long groupId);
}
