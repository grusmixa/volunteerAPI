package ru.ssau.volunteerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.entitie.User;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findAllByCreatorId(User user);
}
