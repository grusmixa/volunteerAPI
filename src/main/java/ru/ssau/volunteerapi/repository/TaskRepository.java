package ru.ssau.volunteerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ssau.volunteerapi.model.entitie.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
