package ru.petryakov.NauJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.Rental;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rentals")
public interface RentalRepository  extends JpaRepository<Rental, Long> {
}
