package kg.nsi.crm.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
public record InterviewResponse (
        String name,
        String gmail,
        String stack,
        String time,
        LocalDate date,
        String location
){
}
