package com.my.graphql.learn.mygraphql.repository;


import com.my.graphql.learn.mygraphql.model.library.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {
        return authors;
    }

    public Author findOne(UUID authorId) {
        return authors.stream()
                .filter(author -> author.getId() == authorId)
                .findFirst().orElseThrow(() -> new RuntimeException("Author not found!"));
    }

    @PostConstruct
    private void init() {
        authors.add(Author.builder()
                .id(UUID.randomUUID())
                .name("Trevolta")
                .books(null)
                .build());
    }
}
