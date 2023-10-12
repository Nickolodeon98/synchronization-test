package com.example.synchronizationtest.service;

import com.example.synchronizationtest.domain.dto.EventRequest;
import com.example.synchronizationtest.domain.dto.EventResponse;
import com.example.synchronizationtest.domain.dto.EventTicketResponse;
import com.example.synchronizationtest.domain.entity.Event;
import com.example.synchronizationtest.domain.entity.EventTicket;
import com.example.synchronizationtest.repository.EventRepository;
import com.example.synchronizationtest.repository.EventTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventTicketRepository eventTicketRepository;

    @Transactional
    public EventResponse createEvent(final EventRequest eventRequest) {
        Event newEvent = eventRepository.save(eventRequest.toEntity());
        return EventResponse.of(newEvent);
    }

    @Transactional
    public EventTicketResponse createEventTicket(final Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        if (event.isClosed()) {
            throw new RuntimeException("마감 되었습니다.");
        }
        EventTicket savedEventTicket = eventTicketRepository.save(EventTicket.get(event));

        return EventTicketResponse.of(savedEventTicket);
    }


}


