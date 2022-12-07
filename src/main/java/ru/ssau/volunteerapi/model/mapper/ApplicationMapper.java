package ru.ssau.volunteerapi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.entitie.Application;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface ApplicationMapper {
    List<ApplicationResponse> toResponses(List<Application> applicationResponses);

    @Mapping(target = "user",source = "userId")
    @Mapping(target = "event",source = "eventId")
    ApplicationResponse toResponse(Application applicationResponse);
}
