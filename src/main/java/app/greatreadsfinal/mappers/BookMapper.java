package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.dtos.CollectionDto;
import app.greatreadsfinal.entities.Books;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Collections;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Books mapToEntity(BooksDto dto);
    @Mapping(target = "status", source = "status")
    @Mapping(target = "bookId", source = "bookId")
    BooksDto mapToDTO(Books entity);
}
