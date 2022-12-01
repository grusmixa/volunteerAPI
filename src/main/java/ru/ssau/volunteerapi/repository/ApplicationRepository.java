package ru.ssau.volunteerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ssau.volunteerapi.model.entitie.Application;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
