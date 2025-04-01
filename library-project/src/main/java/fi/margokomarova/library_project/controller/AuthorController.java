package fi.margokomarova.library_project.controller;

import fi.margokomarova.library_project.dto.AuthorDto;
import fi.margokomarova.library_project.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id){
        return authorService.getAuthorById(id);
    }

}
