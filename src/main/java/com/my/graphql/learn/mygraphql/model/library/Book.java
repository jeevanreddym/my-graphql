package com.my.graphql.learn.mygraphql.model.library;

import lombok.*;

import java.util.UUID;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private UUID id;
    private String title;
    private String publisher;
    private Author author;
}
