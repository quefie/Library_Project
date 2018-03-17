package com.danzal.lib_project.services;


import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.domain.Book;

import java.util.Set;

public interface BookService {

    Set<Book> getBooks();

}
