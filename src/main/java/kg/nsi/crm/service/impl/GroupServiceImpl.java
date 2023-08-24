package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.repository.InternRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.repository.GroupRepository;

import kg.nsi.crm.service.GroupService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
	
	final GroupRepository groupRepository;
	private final InternRepository internRepository;

	@Override
	public SimpleResponse addGroup(GroupRequest group) {

		List<Intern> internList = internRepository.findAllById(group.internsId());

		Group newGroup = new Group();
		newGroup.setName(group.groupName());
		newGroup.setGroupStatus(group.groupStatus());
		newGroup.setFinishDate(group.endDate());
		newGroup.setStartDate(group.startDate());
		newGroup.setInterns(internList);
		newGroup.setCreationDate(LocalDate.now());

		groupRepository.save(newGroup);

		return new SimpleResponse( "The group created successfully", HttpStatus.OK);
	}

	@Override
	public GroupDto getGroupEntityById(Long groupId) {

		Group group = groupRepository.findById(groupId).orElseThrow();

		return GroupDto.builder()
				.id(groupId)
				.name(group.getName())
				.startDate(group.getStartDate())
				.finishDate(group.getFinishDate())
				.groupStatus(group.getGroupStatus()).build();
	}


}
