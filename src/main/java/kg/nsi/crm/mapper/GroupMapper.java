package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;

import java.time.LocalDate;
import java.util.List;

public class GroupMapper {
	public static Group toDto(GroupRequest group, List<Intern> internList) {

		Group newGroup = new Group();
		newGroup.setName(group.groupName());
		newGroup.setGroupStatus(group.groupStatus());
		newGroup.setFinishDate(group.endDate());
		newGroup.setStartDate(group.startDate());
		newGroup.setInterns(internList);
		newGroup.setCreationDate(LocalDate.now());
		return newGroup;
	}

	public static GroupDto toEntity (Group group){
		return GroupDto.builder()
				.id(group.getId())
				.name(group.getName())
				.startDate(group.getStartDate())
				.finishDate(group.getFinishDate())
				.groupStatus(group.getGroupStatus())
				.build();
	}
}
