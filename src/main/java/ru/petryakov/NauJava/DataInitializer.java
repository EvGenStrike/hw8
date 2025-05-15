package ru.petryakov.NauJava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.petryakov.NauJava.entity.Author;
import ru.petryakov.NauJava.entity.Book;
import ru.petryakov.NauJava.entity.Genre;
import ru.petryakov.NauJava.repository.AuthorRepository;
import ru.petryakov.NauJava.repository.BookRepository;
import ru.petryakov.NauJava.repository.GenreRepository;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void run(String... args) {
        Author author = new Author();
        author.setName("Лев Толстой");
        author.setBirthYear(1828);
        author.setCountry("Россия");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Война и мир");
        Genre existingGenre = genreRepository.findByName("Роман");
        if (existingGenre == null){
            Genre genre = new Genre();
            genre.setName("Роман");
            genre.setDescription("Описание жанра");
            genreRepository.save(genre);
            existingGenre = genre;
        }
        book.setPublishedYear(2021);
        genreRepository.save(existingGenre); // Сохраняем жанр в БД

        book.setGenre(existingGenre); // Устанавливаем жанр для книги
        book.setAuthor(author);
        bookRepository.save(book);

        List<Author> russianAuthors = authorRepository.findByCountryAndBirthYear("Россия", 1828);
        System.out.println("Авторы из России 1828 года: " + russianAuthors);

        List<Book> tolstoyBooks = bookRepository.findBooksByAuthorName("Лев Толстой");
        System.out.println("Книги Льва Толстого: " + tolstoyBooks);
    }
}
