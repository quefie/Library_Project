package com.danzal.lib_project.services;

import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.domain.Book;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Book> getBooks() {

        log.debug("I'm in the service");
        Set<Book> books = new HashSet<>();

        bookRepository.findAll().iterator().forEachRemaining(books::add);

        return books;
    }


    @Override
    public Set<Author> getBookAuthors() {
        Set<Author> bookAuthors = new HashSet<>();

        authorRepository.findAll().iterator().forEachRemaining(bookAuthors::add);

        return bookAuthors;
        }
}
