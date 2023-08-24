package kg.nsi.crm.dto.request;

import kg.nsi.crm.enums.GroupStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record GroupRequest (
        String groupName,
        List<Long> internsId,
        GroupStatus groupStatus,
        LocalDate startDate,
        LocalDate endDate
){
}
