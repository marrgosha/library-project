package fi.margokomarova.library_project.repository;

import fi.margokomarova.library_project.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
