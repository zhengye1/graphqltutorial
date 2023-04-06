package com.vincent.graphqltutorial.service;

import com.vincent.graphqltutorial.entity.Author;
import com.vincent.graphqltutorial.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {
    List<Author> authors;

    @PostConstruct
    public void init(){
        authors = Arrays.asList(
            new Author("author-1", "Joshua", "Bloch"),
            new Author("author-2", "Douglas", "Adams"),
            new Author("author-3", "Bill", "Bryson"));
    }

    public Author getById(String id) {
        return authors.stream()
            .filter(author -> author.getId().equals(id))
            .findFirst()
            .orElse(null);
    }


}
