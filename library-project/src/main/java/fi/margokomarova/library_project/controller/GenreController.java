package fi.margokomarova.library_project.controller;

import fi.margokomarova.library_project.dto.GenreDto;
import fi.margokomarova.library_project.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genre/{id}")
    GenreDto getGenreById (@PathVariable("id") Long id){
        return genreService.getGenreById(id);
    }
}
