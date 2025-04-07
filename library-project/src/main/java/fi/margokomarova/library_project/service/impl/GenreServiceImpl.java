package fi.margokomarova.library_project.service.impl;

import fi.margokomarova.library_project.dto.*;
import fi.margokomarova.library_project.model.Author;
import fi.margokomarova.library_project.model.Genre;
import fi.margokomarova.library_project.repository.AuthorRepository;
import fi.margokomarova.library_project.repository.BookRepository;
import fi.margokomarova.library_project.repository.GenreRepository;
import fi.margokomarova.library_project.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        GenreDto genreDto = convertEntityToDto(genre);
        return genreDto;
    }

    private GenreDto convertEntityToDto(Genre genre) {
        List<BookDtoForGenre> bookDtoList = bookRepository.findAll().stream()
                .filter(book -> book.getGenre() == genre)
                .map(book -> BookDtoForGenre.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .authors(book.getAuthors().stream()
                                .map(author -> AuthorResponseDto.builder()
                                        .id(author.getId())
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .build())
                                .toList())
                        .build())
                .toList();

        GenreDto genreDto = GenreDto.builder()
                .id(genre.getId())
                .genre(genre.getName())
                .books(bookDtoList)
                .build();
        return genreDto;
    }
}
