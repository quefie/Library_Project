package com.danzal.lib_project.repositories;

import com.danzal.lib_project.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {

}
