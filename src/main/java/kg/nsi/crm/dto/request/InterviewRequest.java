package kg.nsi.crm.dto.request;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record InterviewRequest(
        List<Long> internIdes,
        String nameOfInterview,
        LocalDate date,
        String startTime,
        String endTime,
        String location,
        String description
) {
}
