package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.EventResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventService {

    SimpleResponse createEvent(EventRequest eventRequest, LocalTime startTime, LocalTime endTime);
    List<EventResponse> getAllSortedEventsByWeek();
    List<EventResponse> getAllEventsByCurrentDay();
    List<EventResponse> getEventsForDayBefore(LocalDate date);
    List<EventResponse> getEventsForDayAfter(LocalDate date);

    List<EventResponse> getEventsForWeekBefore(LocalDate date);
    List<EventResponse> getEventsForWeekAfter(LocalDate date);

    SimpleResponse deleteEvent(Long id);
    List<EventResponse> getAll();

}
