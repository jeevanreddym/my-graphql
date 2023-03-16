package com.my.graphql.learn.mygraphql.model.library;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@Builder
public class Author {
    private UUID id;
    private String name;
    private List<Book> books;
}
