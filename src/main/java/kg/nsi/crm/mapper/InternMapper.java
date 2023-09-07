package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Mentor;

public class InternMapper {

	
	public static Intern toDto(InternRequest intern, Mentor mentor) {
		return Intern.builder()
				.firstName(intern.name())
				.lastName(intern.surname())
				.email(intern.email())
				.phoneNumber(intern.phoneNumber())
				.internStatus(intern.internStatus())
				.paymentCoastPerMonth(intern.paymentCoast())
				.mentor(mentor)
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
				.internStatus(intern.getInternStatus())
				.isPaidForFirstMonth(intern.getIsPaidForFirstMonth())
				.isPaidForSecondMonth(intern.getIsPaidForSecondMonth())
				.isPaidForThirdMonth(intern.getIsPaidForThirdMonth())
				.build();
	}
}
