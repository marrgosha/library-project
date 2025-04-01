package fi.margokomarova.library_project.repository;

import fi.margokomarova.library_project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
