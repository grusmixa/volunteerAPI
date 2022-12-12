package ru.ssau.volunteerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ssau.volunteerapi.model.entitie.Event;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
