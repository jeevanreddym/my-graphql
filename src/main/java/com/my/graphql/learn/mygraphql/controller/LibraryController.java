package com.my.graphql.learn.mygraphql.controller;


import com.my.graphql.learn.mygraphql.model.request.BookInput;
import com.my.graphql.learn.mygraphql.model.library.Author;
import com.my.graphql.learn.mygraphql.model.library.Book;
import com.my.graphql.learn.mygraphql.service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Controller
public class LibraryController {
    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    //@SchemaMapping(typeName = "Query", value = "authors")
    @QueryMapping
    public Iterable<Author> authors() {
        return libraryService.fetchAuthors();
    }

    @QueryMapping
    public Optional<Author> authorById(@Argument UUID authorId) {
        return libraryService.fetchAuthor(authorId);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput bookInput) {

        Author author = libraryService.fetchAuthor(bookInput.getAuthorId()).orElse(null);

        Book book = new Book(UUID.randomUUID(), bookInput.getTitle(), bookInput.getPublisher(), author);

        return libraryService.addBook(book);
    }
}
