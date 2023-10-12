package com.example.synchronizationtest.domain.dto;

import com.example.synchronizationtest.domain.entity.Event;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventRequest {
    long ticketLimit;
    public Event toEntity() {
        return Event.builder()
                .ticketLimit(this.ticketLimit)
                .build();
    }
}
