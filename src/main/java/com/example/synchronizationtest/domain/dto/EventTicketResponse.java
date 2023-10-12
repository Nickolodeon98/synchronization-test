package com.example.synchronizationtest.domain.dto;

import com.example.synchronizationtest.domain.entity.EventTicket;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventTicketResponse {
    long ticketId;
    long eventId;

    public static EventTicketResponse of(EventTicket savedEventTicket) {
        return EventTicketResponse.builder()
                .ticketId(savedEventTicket.getId())
                .eventId(savedEventTicket.getEvent().getId())
                .build();
    }
}
