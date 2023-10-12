package com.example.synchronizationtest.domain.dto;

import com.example.synchronizationtest.domain.entity.Event;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventResponse {
    private long id;
    private long ticketLimit;

    public static EventResponse of(Event newEvent) {
        return EventResponse.builder()
                .id(newEvent.getId())
                .ticketLimit(newEvent.getTicketLimit())
                .build();
    }
}
