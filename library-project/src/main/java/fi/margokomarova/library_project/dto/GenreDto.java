package fi.margokomarova.library_project.dto;

import fi.margokomarova.library_project.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GenreDto {
    private Long id;
    private String genre;
    private List<BookDtoForGenre> books;
}
