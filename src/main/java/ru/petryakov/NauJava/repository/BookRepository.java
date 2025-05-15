package ru.petryakov.NauJava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.Genre;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByGenre(Genre genre);

    @Query("SELECT b FROM Book b WHERE b.author.name = :authorName")
    List<Book> findBooksByAuthorName(String authorName);

    List<Book> findByTitleContaining(String title);
}
