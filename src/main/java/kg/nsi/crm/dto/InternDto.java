package kg.nsi.crm.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kg.nsi.crm.entity.base.BaseEntity;
import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.enums.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternDto{

	Long id;

    LocalDate creationDate;

    LocalDate updateDate;

	String firstName;
    
	String lastName;
    
	String email;
    
	String phoneNumber;
    
    Boolean isPaid;
    
    @Enumerated(EnumType.STRING)
    InternStatus internStatus;

    Long groupId;

    Long stackId;
   
}
