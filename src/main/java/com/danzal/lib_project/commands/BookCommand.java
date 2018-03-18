package com.danzal.lib_project.commands;

import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.domain.Category;
import com.danzal.lib_project.domain.Librarian;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class BookCommand {

    private Long id;
    private String title;
    private String format;
    private String language;
    private int pubYear;
    private String publisher;
    private String description;
    private Librarian librarian;


}
