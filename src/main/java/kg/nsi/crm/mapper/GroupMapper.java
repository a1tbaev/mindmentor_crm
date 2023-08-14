package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.entity.Group;

public class GroupMapper {
	public static Group toDto(GroupDto groupDto) {
		return Group.builder()
				.name(groupDto.getName())
				.startDate(groupDto.getStartDate())
				.groupStatus(groupDto.getGroupStatus())
				.build();
	}

}
