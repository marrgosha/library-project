package fi.margokomarova.library_project.service.impl;

import fi.margokomarova.library_project.dto.AuthorDto;
import fi.margokomarova.library_project.dto.BookDto;
import fi.margokomarova.library_project.model.Author;
import fi.margokomarova.library_project.repository.AuthorRepository;
import fi.margokomarova.library_project.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById(Long id){
        Author author=authorRepository.findById(id).orElseThrow();
        AuthorDto authorDto=convertEntityToDto(author);
        return authorDto;
    }

    private AuthorDto convertEntityToDto(Author author) {
        List<BookDto> bookDtoList=author.getBooks().stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build())
                .toList();
        AuthorDto authorDto=AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .books(bookDtoList)
                .build();
        return authorDto;
    }
}
