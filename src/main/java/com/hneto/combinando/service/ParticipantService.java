package com.hneto.combinando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hneto.combinando.model.Participant;
import com.hneto.combinando.repository.ParticipantRepository;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
}