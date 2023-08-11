package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;

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
				.firstName(intern.getFirstName())
				.lastName(intern.getLastName())
				.email(intern.getEmail())
				.phoneNumber(intern.getPhoneNumber())
				.isPaid(intern.getIsPaid())
				.internStatus(intern.getInternStatus())
				.build();
	}
}
