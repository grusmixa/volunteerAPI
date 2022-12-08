package ru.ssau.volunteerapi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.model.dto.request.EventRequest;
import ru.ssau.volunteerapi.model.dto.response.EventResponse;
import ru.ssau.volunteerapi.model.entitie.Event;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface EventMapper {
    @Mapping(target = "tasks", source = "taskGenerals")
    EventResponse toResponse(Event event, List<TaskGeneral> taskGenerals);

    EventResponse toResponse(Event event);

    @Mapping(target = "tasks", ignore = true)
    List<EventResponse> toResponses(List<Event> event);

    Event toEntity(EventRequest eventRequest);
}
