package ru.ssau.volunteerapi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.ssau.volunteerapi.model.dto.general.TaskGeneral;
import ru.ssau.volunteerapi.model.entitie.Event;
import ru.ssau.volunteerapi.model.entitie.Task;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eventId", ignore = true)
    Task toEntity(TaskGeneral taskGeneral);

    @Mapping(target = "eventId", source = "eventId",qualifiedByName = "fromEventEntityToInteger")
    TaskGeneral toDto(Task task);

    List<TaskGeneral> toDtos(List<Task> tasks);
    @Named("fromEventEntityToInteger")
    default Integer fromEventEntityToInteger(Event event) {
        if (Objects.nonNull(event)) {
            return event.getId();
        }
        return null;
    }
}
