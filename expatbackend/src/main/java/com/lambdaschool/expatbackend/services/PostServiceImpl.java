package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.models.Post;
import com.lambdaschool.expatbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    @Override
    public Post save(Post post){
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public void delete(long id){
        postRepository.deleteById(id);
    }
}
