package kg.nsi.crm.service.impl;

import org.springframework.stereotype.Service;

import kg.nsi.crm.entity.Group;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.service.GroupService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
	
	final GroupRepository groupRepository;
	@Override
	public Group addGroup(Group group) {
		return groupRepository.save(group);
	}

}
