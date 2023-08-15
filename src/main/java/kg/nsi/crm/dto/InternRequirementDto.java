package kg.nsi.crm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import kg.nsi.crm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternRequirementDto {
	Long internId;
	Long requirementId;
	Boolean isFinished;

}
