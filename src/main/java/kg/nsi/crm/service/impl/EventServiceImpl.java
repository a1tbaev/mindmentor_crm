package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Event;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.mapper.EventMapper;
import kg.nsi.crm.repository.EventRepository;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.service.EventService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventServiceImpl implements EventService {

     final EventRepository eventRepository;
     final GroupRepository groupRepository;
    @Override
    public SimpleResponse createEvent(EventRequest eventRequest, LocalTime startTime, LocalTime endTime) {

        Group group = groupRepository.getById(eventRequest.getGroupId());
        eventRepository.save(EventMapper.toEntity(eventRequest,group, startTime, endTime));
        return new SimpleResponse("Event is successfully created!", HttpStatus.OK);
    }


}
