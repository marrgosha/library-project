package fi.margokomarova.library_project.repository;

import fi.margokomarova.library_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
