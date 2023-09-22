package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.EventRequest;
import kg.nsi.crm.dto.response.SimpleResponse;

import java.time.LocalTime;

public interface EventService {

    SimpleResponse createEvent(EventRequest eventRequest, LocalTime startTime, LocalTime endTime);


}
