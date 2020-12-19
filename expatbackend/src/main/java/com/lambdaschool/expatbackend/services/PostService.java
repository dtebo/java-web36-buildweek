package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.models.Post;

public interface PostService {
    Post save(Post post);
    void delete(long id);
}
