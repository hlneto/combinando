package com.hneto.combinando.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hneto.combinando.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
	
	List<Event> findByLastModifiedBefore(LocalDateTime dateTime);
}