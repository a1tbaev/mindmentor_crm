package kg.nsi.crm.dto.response;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;
@Value
@Builder
public class EventResponse {

    String meetingName;
    String location;
    String description;
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
    String groupName;
}
