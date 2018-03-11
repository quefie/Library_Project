package com.danzal.lib_project.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "books")
    private Set<Book> books;
    private String nationality;




}
