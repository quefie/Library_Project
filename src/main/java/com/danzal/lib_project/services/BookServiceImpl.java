package com.danzal.lib_project.services;

import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.domain.Book;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getBooks() {
        Set<Book> books = new HashSet<>();

        bookRepository.findAll().iterator().forEachRemaining(books::add);

        return books;
    }
}
