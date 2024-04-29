package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.entities.Books;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    Books mapToEntity(BooksDto dto);
    BooksDto mapToDTO(Books entity);
}
