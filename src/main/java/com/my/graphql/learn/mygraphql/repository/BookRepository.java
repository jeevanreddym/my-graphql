package com.my.graphql.learn.mygraphql.repository;


import com.my.graphql.learn.mygraphql.model.library.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public Book findOne(UUID bookId) {
        return books.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst().orElseThrow(() -> new RuntimeException("Book not found!"));
    }

    @PostConstruct
    private void init() {
        books.addAll(List.of(
                Book.builder()
                        .id(UUID.randomUUID())
                        .title("Jungle Book")
                        .build(),
                Book.builder()
                        .id(UUID.randomUUID())
                        .title("Spy Kid")
                        .build()
        ));
    }
}
