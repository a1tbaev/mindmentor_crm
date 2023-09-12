package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;

import java.util.List;

public class GroupMapper {
	public static Group toEntity(GroupRequest group, List<Intern> internList) {

		return Group.builder()
				.name(group.groupName())
				.groupStatus(group.groupStatus())
				.startDate(group.startDate())
				.finishDate(group.endDate())
				.interns(internList)
				.build();
	}

	public static GroupDto toDto (Group group){
		return GroupDto.builder()
				.id(group.getId())
				.name(group.getName())
				.startDate(group.getStartDate())
				.finishDate(group.getFinishDate())
				.groupStatus(group.getGroupStatus())
				.build();
	}
}
