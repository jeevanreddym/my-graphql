package com.my.graphql.learn.mygraphql.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@Data
public class BookInput {
    String title;
    String publisher;
    UUID authorId;
}
