package ru.petryakov.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.petryakov.NauJava.entity.Author;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "authors")
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByCountryAndBirthYear(String country, int birthYear);
}
