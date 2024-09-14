package com.hneto.combinando.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hneto.combinando.model.Event;
import com.hneto.combinando.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> findEventById(UUID id) {
        return eventRepository.findById(id);
    }
}