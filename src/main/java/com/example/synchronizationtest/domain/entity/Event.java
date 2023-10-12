package com.example.synchronizationtest.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long ticketLimit;

    @OneToMany(mappedBy = "event")
    private List<EventTicket> eventTickets;

    public boolean isClosed() {
        return eventTickets.size() >= ticketLimit;
    }
}
