package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.mapper.GroupMapper;
import kg.nsi.crm.repository.GroupRepository;

import kg.nsi.crm.service.GroupService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
	
	private final GroupRepository groupRepository;
	@Override
	public SimpleResponse addGroup(GroupDto group) {
		groupRepository.save(GroupMapper.toDto(group));
		return new SimpleResponse( "The group created successfully", HttpStatus.OK);
	}
	@Override
	public Group getGroupEntityById(Long groupId) {
		return groupRepository.findById(groupId).orElseThrow(RuntimeException::new);
	}

}
