package fi.margokomarova.library_project.service;

import fi.margokomarova.library_project.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
}
