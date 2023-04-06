package com.vincent.graphqltutorial.controller;

import com.vincent.graphqltutorial.entity.Author;
import com.vincent.graphqltutorial.entity.Book;
import com.vincent.graphqltutorial.service.AuthorService;
import com.vincent.graphqltutorial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.findById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getById(book.getAuthorId());
    }
}
