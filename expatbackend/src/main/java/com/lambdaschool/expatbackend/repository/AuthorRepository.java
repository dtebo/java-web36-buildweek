package com.lambdaschool.expatbackend.repository;

import com.lambdaschool.expatbackend.models.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
    Author findByNameContainingIgnoreCase(String n);
}
