package com.hneto.combinando.controller;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hneto.combinando.exception.EventNotFoundException;
import com.hneto.combinando.model.Event;
import com.hneto.combinando.model.Participant;
import com.hneto.combinando.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/new")
    public String showCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "create_event";
    }

    @PostMapping("/new")
    public String createEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/events/" + event.getId();
    }

    @GetMapping("/{id}")
    public String viewEvent(@PathVariable UUID id, Model model) {
        Event event = eventService.findEventById(id).orElseThrow(() -> new EventNotFoundException("Evento não encontrado."));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = event.getDate().format(formatter);
        
        model.addAttribute("event", event);
        model.addAttribute("participant", new Participant());
        model.addAttribute("formattedDate", formattedDate);
        return "view_event";
    }
}