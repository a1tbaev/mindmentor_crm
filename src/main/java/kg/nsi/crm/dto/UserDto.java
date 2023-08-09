package kg.nsi.crm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import kg.nsi.crm.enums.Role;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String username;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Role role;

}
