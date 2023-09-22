package kg.nsi.crm.dto.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;

@Value
@Builder
public class EventRequest {
    String meetingName;
    String location;
    String description;
    LocalDate date;
    Long groupId;
}
