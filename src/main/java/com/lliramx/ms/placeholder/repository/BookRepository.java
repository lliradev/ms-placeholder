package com.lliramx.ms.placeholder.repository;

import com.lliramx.ms.placeholder.model.Book;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    private String genre;

    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Java 1.8", "Antonio 1", 2020, genre),
            new Book(2, "Java 11", "Antonio 2", 2021, genre),
            new Book(3, "Java 17", "Antonio 3", 2022, genre),
            new Book(4, "Java 21", "Antonio 4", 2023, genre),
            new Book(5, "Java 20", "Antonio 5", 2024, genre)
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks()
            .stream()
            .filter(book -> book.id() == id)
            .findFirst();
    }
}
