package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();
    Post findPostByTitle(String substr);
    Post save(Post post);
    Post update(Post post, long id);
    void delete(long id);
}
