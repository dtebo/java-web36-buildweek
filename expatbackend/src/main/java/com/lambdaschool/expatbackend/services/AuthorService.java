package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    Author findByName(String n);
    Author save(Author author);
    Author update(Author author, long id);
    void delete(long id);
}
