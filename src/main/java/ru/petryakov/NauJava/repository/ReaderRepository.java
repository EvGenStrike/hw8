package ru.petryakov.NauJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petryakov.NauJava.entity.Reader;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "readers")
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
