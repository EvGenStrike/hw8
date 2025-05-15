package ru.petryakov.NauJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.Genre;
import ru.petryakov.NauJava.repository.BookRepository;
import ru.petryakov.NauJava.repository.GenreRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomQueryController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/genre")
    public Genre getGenreByName(@RequestParam String name) {
        return genreRepository.findByName(name);
    }

    @GetMapping("/book/genre")
    public List<Book> getBooksByGenre(@RequestParam String genreName) {
        Genre genre = genreRepository.findByName(genreName);
        return bookRepository.findByGenre(genre);
    }

    @GetMapping("/book/author")
    public List<Book> getBooksByAuthor(@RequestParam String authorName) {
        return bookRepository.findBooksByAuthorName(authorName);
    }

    @GetMapping("/book/title")
    public List<Book> getBooksByTitle(@RequestParam String title) {
        return bookRepository.findByTitleContaining(title);
    }
}
