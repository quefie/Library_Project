package com.danzal.lib_project.repositories;

import com.danzal.lib_project.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
