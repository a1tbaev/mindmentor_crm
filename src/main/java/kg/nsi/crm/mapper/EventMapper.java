package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.EventResponse;
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
                .location(eventRequest.getLocation())
                .build();

    }

    public static EventResponse toDto(Event event){
        return EventResponse.builder()
                .meetingName(event.getMeetingName())
                .date(event.getDate())
                .groupName(event.getGroup().getName())
                .location(event.getLocation())
                .description(event.getDescription())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .build();
    }


}
