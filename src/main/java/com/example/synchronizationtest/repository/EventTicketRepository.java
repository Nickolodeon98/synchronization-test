package com.example.synchronizationtest.repository;

import com.example.synchronizationtest.domain.entity.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTicketRepository extends JpaRepository<EventTicket, Long> {
}
