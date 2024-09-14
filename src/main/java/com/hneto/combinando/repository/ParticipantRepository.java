package com.hneto.combinando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hneto.combinando.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
}