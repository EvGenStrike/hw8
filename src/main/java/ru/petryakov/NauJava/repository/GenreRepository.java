package ru.petryakov.NauJava.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.Genre;

@RepositoryRestResource(path = "genres")
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
