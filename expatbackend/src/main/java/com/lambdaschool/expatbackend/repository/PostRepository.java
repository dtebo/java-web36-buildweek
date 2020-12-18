package com.lambdaschool.expatbackend.repository;

import com.lambdaschool.expatbackend.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
