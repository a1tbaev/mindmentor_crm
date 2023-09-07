package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;

public class InternMapper {

	
	public static Intern toDto(InternRequest intern, Mentor mentor, Stack stack) {
		return Intern.builder()
				.firstName(intern.name())
				.lastName(intern.surname())
				.email(intern.email())
				.phoneNumber(intern.phoneNumber())
				.isPaid(intern.isPaid())
				.internStatus(intern.internStatus())
				.mentor(mentor)
				.stack(stack)
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
				.build();
	}
}
