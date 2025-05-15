package ru.petryakov.NauJava;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private int year;
    private String edition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return String.format("Книга [id=%d, Название='%s', Автор='%s', Жанр='%s', Год=%d, Издание='%s']",
                id, title, author, genre, year, edition);
    }
}