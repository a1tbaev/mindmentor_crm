package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.EventResponse;
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<EventResponse> getAllSortedEventsByWeek() {

        TemporalField weekField = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int currentWeekNumber = LocalDate.now().get(weekField);

        List<EventResponse> events = eventRepository.findAll()
                .stream()
                .filter(event -> {
                    int eventWeekNumber = event.getDate().get(weekField);
                    return eventWeekNumber == currentWeekNumber;
                })
                .map(EventMapper::toDto)
                .collect(Collectors.toList());

        events.sort(Comparator.comparing(EventResponse::getDate));

        return events;
    }

    @Override
    public List<EventResponse> getAllEventsByCurrentDay() {
        LocalDate currentDate = LocalDate.now();

        List<EventResponse> events = eventRepository.findAll()
                .stream()
                .filter(event -> event.getDate().isEqual(currentDate))
                .map(EventMapper::toDto)
                .collect(Collectors.toList());

        return events;
    }

    @Override
    public List<EventResponse> getEventsForDayBefore(LocalDate date) {
        LocalDate dayBefore = date.minusDays(1);
        List<EventResponse> events = eventRepository.findAll()
                .stream()
                .filter(event -> event.getDate().isEqual(dayBefore))
                .map(EventMapper::toDto)
                .collect(Collectors.toList());

        return events;
    }

    @Override
    public List<EventResponse> getEventsForDayAfter(LocalDate date) {
        LocalDate dayAfter = date.plusDays(1);
        List<EventResponse> events = eventRepository.findAll()
                .stream()
                .filter(event -> event.getDate().isEqual(dayAfter))
                .map(EventMapper::toDto)
                .collect(Collectors.toList());

        return events;
    }

    @Override
    public List<EventResponse> getEventsForWeekBefore(LocalDate date) {
        LocalDate startOfPreviousWeek = date.minusWeeks(1);

        LocalDate endOfPreviousWeek = startOfPreviousWeek.plusDays(6);

        List<EventResponse> events = eventRepository.findAll()
                .stream()
                .filter(event -> {
                    LocalDate eventDate = event.getDate();
                    return !eventDate.isBefore(startOfPreviousWeek) && !eventDate.isAfter(endOfPreviousWeek);
                })
                .map(EventMapper::toDto)
                .collect(Collectors.toList());

        return events;
    }

    @Override
    public List<EventResponse> getEventsForWeekAfter(LocalDate date) {
        LocalDate startOfNextWeek = date.plusWeeks(1);

        // Calculate the end date of the next week
        LocalDate endOfNextWeek = startOfNextWeek.plusDays(6);

        // Filter events that will occur within the next week
        List<EventResponse> events = eventRepository.findAll()
                .stream()
                .filter(event -> {
                    LocalDate eventDate = event.getDate();
                    return !eventDate.isBefore(startOfNextWeek) && !eventDate.isAfter(endOfNextWeek);
                })
                .map(EventMapper::toDto)
                .collect(Collectors.toList());

        return events;
    }

    @Override
    public SimpleResponse deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        System.out.println(event.getMeetingName());
        eventRepository.delete(event);
        return new SimpleResponse("Event deleted successfully!", HttpStatus.OK);
    }


}
