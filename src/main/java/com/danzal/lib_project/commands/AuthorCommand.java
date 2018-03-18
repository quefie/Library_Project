package com.danzal.lib_project.commands;

import com.danzal.lib_project.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class AuthorCommand {

    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Set<Long> bookId = new HashSet<>();
    private Set<BookCommand> books = new HashSet<>();
}
