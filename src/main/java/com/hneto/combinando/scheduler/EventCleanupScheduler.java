package com.hneto.combinando.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hneto.combinando.model.Event;
import com.hneto.combinando.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EventCleanupScheduler {

    @Autowired
    private EventRepository eventRepository;

    // Agendador executado diariamente às 00:00 (meia-noite)
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteOldEvents() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
        
        // Busca eventos com `lastModified` mais antigos que 7 dias
        List<Event> oldEvents = eventRepository.findByLastModifiedBefore(oneWeekAgo);
        
        if (!oldEvents.isEmpty()) {
            eventRepository.deleteAll(oldEvents);
        }
    }
}