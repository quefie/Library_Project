package com.danzal.lib_project.services;

import com.danzal.lib_project.domain.Author;

import java.util.Set;

public interface AuthorService {

    Set<Author> getAuthors();

    Author findById(Long l);
}
