package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.BooksDto;
import app.greatreadsfinal.dtos.CollectionDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.Collection;
import org.mapstruct.*;

import java.util.Collections;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Books mapToEntity(BooksDto dto);
    @Mapping(target = "status", source = "status")
    @Mapping(target = "bookId", source = "bookId")
    @Mapping(target = "collection", source = "collection", qualifiedByName = "mapCollection")
    BooksDto mapToDTO(Books entity);

    @Named("mapCollection")
    default CollectionDto mapCollectionToDto(Collection collection) {
        if (collection == null) {
            return null;
        }
        CollectionDto dto = new CollectionDto();
        dto.setName(collection.getCollectionName());
        return dto;
    }
}
