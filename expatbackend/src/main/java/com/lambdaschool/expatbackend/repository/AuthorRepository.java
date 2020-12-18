package com.lambdaschool.expatbackend.repository;

import com.lambdaschool.expatbackend.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
