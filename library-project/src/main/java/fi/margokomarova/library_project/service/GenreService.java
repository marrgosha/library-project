package fi.margokomarova.library_project.service;

import fi.margokomarova.library_project.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreById(Long id);
}
