package com.hneto.combinando.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.hneto.combinando.model.Event;
import com.hneto.combinando.model.Participant;
import com.hneto.combinando.service.EventService;
import com.hneto.combinando.service.ParticipantService;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    
    @Autowired
    private EventService eventService;

    @PostMapping("/add")
    @Transactional
    public String addParticipant(@ModelAttribute Participant participant, @RequestParam UUID eventId) {
        Event event = eventService.findEventById(eventId).orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + eventId));
        participant.setEvent(event);
        participantService.saveParticipant(participant);
        return "redirect:/" + eventId + "?refresh=true";
    }
}
