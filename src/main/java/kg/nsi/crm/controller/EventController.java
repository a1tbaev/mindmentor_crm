package kg.nsi.crm.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.EventResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Event;
import kg.nsi.crm.repository.EventRepository;
import kg.nsi.crm.service.impl.EventServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Event", description = "The Event API")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @Operation(summary = "Get All Events Related to current week", description = "Get All Events Related to current week")
    @GetMapping("/getWeek")
    public List<EventResponse> getAllSortedEventsByWeek(){
        return eventService.getAllSortedEventsByWeek();
    }
    @Operation(summary = "Get All Events Related to current day", description = "Get All Events Related to current day")
    @GetMapping("/getDay")
    public List<EventResponse> getAllEventsByCurrentDay(){
        return eventService.getAllEventsByCurrentDay();
    }
    @Operation(summary = "Get All Events for day before", description = "Get All Events for day before")
    @GetMapping("/getDayBefore")
    public List<EventResponse> getEventsForDayBefore(@RequestParam LocalDate date){
        return eventService.getEventsForDayBefore(date);
    }
    @Operation(summary = "Get All Events for day after", description = "Get All Events for day after")
    @GetMapping("/getDayAfter")
    public List<EventResponse> getEventsForDayAfter(@RequestParam LocalDate date){
        return eventService.getEventsForDayAfter(date);
    }

    @Operation(summary = "Get All Events for week before", description = "Get All Events for week before")
    @GetMapping("/getWeekBefore")
    public List<EventResponse> getEventsForWeekBefore(@RequestParam LocalDate date){
        return eventService.getEventsForWeekBefore(date);
    }
    @Operation(summary = "Get All Events for week after", description = "Get All Events for week after")
    @GetMapping("/getWeekAfter")
    public List<EventResponse> getEventsForWeekAfter(@RequestParam LocalDate date) {
        return eventService.getEventsForWeekAfter(date);
    }
    @Operation(summary = "Delete event", description = "Delete event")
    @DeleteMapping("/{eventId}")
    public SimpleResponse deleteEvent(@PathVariable Long eventId){
        return eventService.deleteEvent(eventId);
    }

    @Operation(summary = "Get all events", description = "Get all events")
    @GetMapping("/getAll")
    public List<EventResponse> getAll(){
        return eventService.getAll();
    }

    @Operation(summary = "Create a new event", description = "This method is to create a new event")
    @PostMapping("/")
    public SimpleResponse createEvent(@NotNull @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startTime,
                                      @NotNull @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endTime,
                                      @RequestBody EventRequest eventRequest){
        LocalTime localStartTime = startTime.toLocalTime();
        LocalTime localEndTime = endTime.toLocalTime();

        return eventService.createEvent(eventRequest, localStartTime, localEndTime);
    }
}
