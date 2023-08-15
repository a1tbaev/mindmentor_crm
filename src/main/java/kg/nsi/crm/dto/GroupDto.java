package kg.nsi.crm.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import kg.nsi.crm.enums.GroupStatus;
import kg.nsi.crm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {

	String name;
	LocalDate startDate;
	LocalDate finishDate;
	GroupStatus groupStatus;
}
