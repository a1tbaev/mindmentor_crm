package kg.nsi.crm.service.impl;

import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.mapper.GroupMapper;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.results.Result;
import kg.nsi.crm.results.SuccessResult;
import kg.nsi.crm.service.GroupService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
	
	final GroupRepository groupRepository;
	@Override
	public Result addGroup(GroupDto group) {
		groupRepository.save(GroupMapper.toDto(group));
		return new SuccessResult("Group added");
	}
	@Override
	public Group getGroupEntityById(Long groupId) {
		return groupRepository.findById(groupId).orElseThrow(RuntimeException::new);
	}

}
