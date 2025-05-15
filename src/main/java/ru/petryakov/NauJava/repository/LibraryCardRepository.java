package ru.petryakov.NauJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petryakov.NauJava.entity.LibraryCard;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "libraryCards")
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {
}
