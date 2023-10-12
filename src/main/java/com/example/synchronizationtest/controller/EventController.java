package com.example.synchronizationtest.controller;

import com.example.synchronizationtest.domain.dto.EventRequest;
import com.example.synchronizationtest.domain.dto.EventResponse;
import com.example.synchronizationtest.domain.dto.EventTicketResponse;
import com.example.synchronizationtest.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody final EventRequest request) {
        EventResponse eventResponse = eventService.createEvent(request);

        return ResponseEntity.created(URI.create("/events/" + eventResponse.getId())).body(eventResponse);
    }

    @PostMapping("/{eventId}/tickets")
    public ResponseEntity<EventTicketResponse> createEventTicket(@PathVariable final Long eventId) {
        EventTicketResponse response = eventService.createEventTicket(eventId);

        return ResponseEntity.created(URI.create("/events/" + response.getEventId() + "/" + response.getTicketId()))
                .body(response);
    }

}
