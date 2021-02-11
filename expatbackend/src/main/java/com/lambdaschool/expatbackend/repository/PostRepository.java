package com.lambdaschool.expatbackend.repository;

import com.lambdaschool.expatbackend.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    Post findPostByTitleContainingIgnoreCase(String substr);
}
