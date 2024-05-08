package app.greatreadsfinal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDtoForTable {
    private String bookName;
    private LocalDateTime addDate;
    private String wish;
    private LocalDateTime endReadingDate;
    private LocalDateTime startReadingDate;
    private List<String> authors;

}

