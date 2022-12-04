package ru.ssau.volunteerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ssau.volunteerapi.model.entitie.Application;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.entitie.User;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    List<Application> findByUserId(User user);
    List<Application> findAllByEventId(Event event);
}
