package kg.nsi.crm.dto;

import java.time.LocalDate;

import kg.nsi.crm.enums.GroupStatus;
import lombok.Builder;

@Builder
public record GroupDto (
		Long id,
		String name,
		LocalDate startDate,
		LocalDate finishDate,
		int numberOfStudents,
		GroupStatus groupStatus
){
}
