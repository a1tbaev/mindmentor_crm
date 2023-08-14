package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.service.impl.GroupServiceImpl;
import kg.nsi.crm.service.impl.StackServiceImpl;
import lombok.RequiredArgsConstructor;

public class InternMapper {

	
	public static Intern toDto(InternDto intern, Group group) {
		return Intern.builder()
				.firstName(intern.getFirstName())
				.lastName(intern.getLastName())
				.email(intern.getEmail())
				.phoneNumber(intern.getPhoneNumber())
				.isPaid(intern.getIsPaid())
				.internStatus(intern.getInternStatus())
				.group(group)
				.build();
	}
	
	public static InternDto toEntity(Intern intern) {
		return InternDto.builder()
				.id(intern.getId())
				.creationDate(intern.getCreationDate())
				.updateDate(intern.getUpdateDate())
				.firstName(intern.getFirstName())
				.lastName(intern.getLastName())
				.email(intern.getEmail())
				.phoneNumber(intern.getPhoneNumber())
				.isPaid(intern.getIsPaid())
				.internStatus(intern.getInternStatus())
				.groupId(intern.getGroup().getId())
				.build();
	}
}
