package com.danzal.lib_project.controllers.authors;

import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.services.Author.AuthorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AuthorsControllerTest {

    @Mock
    AuthorService authorService;

    @Mock
    Model model;


    AuthorsController authorsController;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        authorsController = new AuthorsController(authorService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authorsController).build();

        mockMvc.perform(get("/authors/home/")).
                andExpect(status().isOk()).
                andExpect(view().name("/authors/home"));
    }

    @Test
    public void showAuthors() {

        Set<Author> authors = new HashSet<>();
        authors.add(new Author());

        Author author = new Author();
        author.setLastName("Frank");

        authors.add(author);

        when(authorService.getAuthors()).thenReturn(authors);

        ArgumentCaptor<Set<Author>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = authorsController.showAuthors(model);

        assertEquals("/authors/home", viewName);
        verify(authorService, times(1)).getAuthors();
        verify(model, times(1)).addAttribute(eq("authors"),argumentCaptor.capture());
        Set<Author> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}