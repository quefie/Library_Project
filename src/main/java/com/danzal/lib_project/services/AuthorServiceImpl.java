package com.danzal.lib_project.services;

import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Author> getAuthors() {
        Set<Author> authors = new HashSet<>();

        authorRepository.findAll().iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Override
    public Author findById(Long l) {
        return null;
    }
}
