package com.my.graphql.learn.mygraphql.service;


import com.my.graphql.learn.mygraphql.model.library.Author;
import com.my.graphql.learn.mygraphql.model.library.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LibraryService {

    private List<Book> books = List.of(
            Book.builder()
                    .id(UUID.randomUUID())
                    .title("Jungle Book")
                    .build(),
            Book.builder()
                    .id(UUID.randomUUID())
                    .title("Spy Kid")
                    .build()
    );

    private List<Author> authors = List.of(
            Author.builder()
                    .id(UUID.randomUUID())
                    .name("Trevolta")
                    .books(books)
                    .build()
    );

    public Iterable<Author> fetchAuthors() {
        return authors;
    }

    public Optional<Author> fetchAuthor(UUID authorId) {
        return authors.stream().filter(a -> a.getId() == authorId).findFirst();
    }

    public Optional<Book> fetchBook(UUID bookId) {
        return books.stream().filter(b -> b.getId() == bookId).findFirst();
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }
}
