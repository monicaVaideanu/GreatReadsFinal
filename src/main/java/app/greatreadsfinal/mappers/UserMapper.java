package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.UserDetailsDto;
import app.greatreadsfinal.entities.UserD;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserD toEntity(UserDetailsDto dto);
    UserDetailsDto toDTO(UserD entity);
}
