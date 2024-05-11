package app.greatreadsfinal.mappers;

import app.greatreadsfinal.dtos.ReviewDto;
import app.greatreadsfinal.entities.Books;
import app.greatreadsfinal.entities.Review;
import app.greatreadsfinal.entities.UserD;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "bookId", target = "bookId", qualifiedByName = "booksToLong")
    @Mapping(source = "userId", target = "userId", qualifiedByName = "userDToLong")
    @Mapping(source = "userId.username", target = "username")
    @Mapping(source = "publishedDate", target = "publishedDate")
    ReviewDto mapToDTO(Review entity);

    @Mapping(target = "bookId", source = "bookId", qualifiedByName = "longToBooks")
    @Mapping(target = "userId", source = "userId", qualifiedByName = "longToUserD")
    @Mapping(target = "publishedDate", source = "publishedDate")
    Review mapToEntity(ReviewDto dto);

    @Named("booksToLong")
    default Long booksToLong(Books books) {
        return books == null ? null : books.getBookId();
    }

    @Named("userDToLong")
    default Long userDToLong(UserD user) {
        return user == null ? null : user.getUserDetailsId();
    }

    // Implement or annotate these methods if they are missing
    @Named("longToBooks")
    default Books longToBooks(Long id) {
        // implementation needed
        return null;
    }

    @Named("longToUserD")
    default UserD longToUserD(Long id) {
        // implementation needed
        return null;
    }
}
