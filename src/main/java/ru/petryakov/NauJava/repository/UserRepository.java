package ru.petryakov.NauJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
