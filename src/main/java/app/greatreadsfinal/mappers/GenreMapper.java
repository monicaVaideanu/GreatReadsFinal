package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.GenreDto;
import app.greatreadsfinal.entities.Genre;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface GenreMapper {

    Genre mapToEntity(GenreDto dto);

    GenreDto mapToDTO(Genre entity);
}