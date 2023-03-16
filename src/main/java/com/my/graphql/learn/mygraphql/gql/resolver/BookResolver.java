package com.my.graphql.learn.mygraphql.gql.resolver;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.my.graphql.learn.mygraphql.model.library.Author;
import com.my.graphql.learn.mygraphql.model.library.Book;
import com.my.graphql.learn.mygraphql.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookResolver implements GraphQLResolver<Book>
{

    private LibraryService libraryService;

    @Autowired
    public BookResolver(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public Optional<Book> getBook(Author author) {
        return libraryService.fetchBook(author.getId());
    }
}
