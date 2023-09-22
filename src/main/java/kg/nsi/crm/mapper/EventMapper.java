package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.entity.Event;
import kg.nsi.crm.entity.Group;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;


@Builder
public class EventMapper {

    public static Event toEntity(EventRequest eventRequest, Group group, LocalTime startTime, LocalTime endTime){
        return Event.builder()
                .meetingName(eventRequest.getMeetingName())
                .date(eventRequest.getDate())
                .description(eventRequest.getDescription())
                .endTime(endTime)
                .startTime(startTime)
                .group(group)
                .build();

    }
}
