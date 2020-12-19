package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.models.Author;

public interface AuthorService {
    Author save(Author author);
    void delete(long id);
}
