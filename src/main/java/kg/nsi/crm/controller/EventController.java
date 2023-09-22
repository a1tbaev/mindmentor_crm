package kg.nsi.crm.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Event;
import kg.nsi.crm.repository.EventRepository;
import kg.nsi.crm.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@Tag(name = "Event", description = "The Event API")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private EventRepository eventRepository;


    @Operation(summary = "Create a new event", description = "This method is to create a new event")
    @PostMapping("/")
    public SimpleResponse createEvent(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startTime,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endTime,
                                      @RequestBody EventRequest eventRequest){
        LocalTime localStartTime = startTime.toLocalTime();
        LocalTime localEndTime = endTime.toLocalTime();

        return eventService.createEvent(eventRequest, localStartTime, localEndTime);
    }




}
