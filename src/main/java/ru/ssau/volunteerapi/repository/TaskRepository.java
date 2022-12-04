package ru.ssau.volunteerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.entitie.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findByEventId(Event event);
    void deleteAllByEventId(Event event);
}
