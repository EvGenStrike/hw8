package ru.petryakov.NauJava;

public interface IBookService {
    void createBook(Long id, String title, String author, String genre, int year, String edition);
    Book findBookById(Long id);
    void deleteBookById(Long id);
    void updateBookInfo(Long id, String title, String author, String genre, int year, String edition);
}