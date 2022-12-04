package ru.ssau.volunteerapi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.ssau.volunteerapi.model.dto.response.ApplicationResponse;
import ru.ssau.volunteerapi.model.entitie.Application;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationMapper {
    List<ApplicationResponse> toResponses(List<Application> applicationResponses);
    ApplicationResponse toResponse(Application applicationResponse);
}
