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
				.internStatus(intern.internStatus())
				.isPaidForFirstMonth(false)
				.isPaidForSecondMonth(false)
				.isPaidForThirdMonth(false)
				.paymentCoastPerMonth(intern.paymentCost())
				.mentor(mentor)
				.stack(stack)
				.build();
	}
	
	public static InternDto toEntity(Intern intern) {

		String groupName = null;
		String mentorName = null;

		if (intern.getGroup() != null) groupName = intern.getGroup().getName();
		if (intern.getMentor().getFirstName() != null) mentorName = intern.getMentor().getFirstName();

		return InternDto.builder()
				.id(intern.getId())
				.creationDate(intern.getCreationDate())
				.updateDate(intern.getUpdateDate())
				.firstName(intern.getFirstName())
				.lastName(intern.getLastName())
				.email(intern.getEmail())
				.balance(intern.getBalance())
				.phoneNumber(intern.getPhoneNumber())
				.internStatus(intern.getInternStatus())
				.isPaidForFirstMonth(intern.getIsPaidForFirstMonth())
				.isPaidForSecondMonth(intern.getIsPaidForSecondMonth())
				.isPaidForThirdMonth(intern.getIsPaidForThirdMonth())
				.stackName(intern.getStack().getName())
				.groupName(groupName)
				.mentorName(mentorName)
				.build();
	}
}
