package ru.petryakov.NauJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.Review;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "reviews")
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
