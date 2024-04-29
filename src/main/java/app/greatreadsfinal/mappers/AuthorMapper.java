package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.AuthorDto;
import app.greatreadsfinal.entities.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author mapToEntity(AuthorDto dto);
    AuthorDto mapToDTO(Author entity);
}
