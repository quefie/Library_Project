package com.danzal.lib_project.services;

import com.danzal.lib_project.converters.Author.AuthorCommandToAuthor;
import com.danzal.lib_project.converters.Author.AuthorToAuthorCommand;
import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.repositories.BookRepository;
import com.danzal.lib_project.services.Author.AuthorService;
import com.danzal.lib_project.services.Author.AuthorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthorServiceImplTest {

    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Mock
    AuthorCommandToAuthor authorCommandToAuthor;

    @Mock
    AuthorToAuthorCommand authorToAuthorCommand;

    @Mock
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        authorService = new AuthorServiceImpl(authorRepository,authorCommandToAuthor,authorToAuthorCommand,bookRepository);
    }

    @Test
    public void getAuthors() {

        Author author = new Author();
        HashSet authorsData = new HashSet();
        authorsData.add(author);


        when(authorService.getAuthors()).thenReturn(authorsData);
        Set<Author> authors = authorService.getAuthors();

        assertEquals(authors.size(), 1);
        verify(authorRepository, times(1)).findAll();

    }
}