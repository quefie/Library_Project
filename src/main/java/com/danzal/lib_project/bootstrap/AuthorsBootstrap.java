package com.danzal.lib_project.bootstrap;


import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorsBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        authorRepository.saveAll(getAuthors());
    }

    private List<Author> getAuthors(){
        List<Author> authors = new ArrayList<>();

        Author author1 = new Author("First 1#", "Last 1#", "Poland #1");
        Author author2 = new Author("First 2#", "Last 2#", "Poland #2");
        Author author3 = new Author("First 3#", "Last 3#", "Poland #3");

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);


        return authors;

    }
}
