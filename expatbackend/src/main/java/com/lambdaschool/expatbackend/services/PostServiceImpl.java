package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.exceptions.ResourceNotFoundException;
import com.lambdaschool.expatbackend.models.Author;
import com.lambdaschool.expatbackend.models.Post;
import com.lambdaschool.expatbackend.repository.AuthorRepository;
import com.lambdaschool.expatbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "postService")
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Post> findAllPosts(){
        List<Post> myPosts = postRepository.findAll();

        return myPosts;
    }

    @Override
    public Post findPostByTitle(String substr){
        Post post = postRepository.findPostByTitleContainingIgnoreCase(substr);

        if(post != null){
            return post;
        }
        else{
            throw new ResourceNotFoundException("Post " + substr + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Post save(Post post){
        Post newPost = new Post();

        if(post.getPostid() != 0){
            postRepository.findById(post.getPostid())
                    .orElseThrow(() -> new ResourceNotFoundException("Post " + post.getPostid() + " Not Found!"));

            newPost.setPostid(post.getPostid());
        }

        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        newPost.setPostedDate(post.getPostedDate());
        newPost.setImgUrl(post.getImgUrl());
        newPost.setAuthor(post.getAuthor());

        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post update(Post post, long id){
        Post currentPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post " + id + " Not Found!"));

        if(post.getTitle() != null){
            currentPost.setTitle(post.getTitle());
        }

        if(post.getBody() != null){
            currentPost.setBody(post.getBody());
        }

        if(post.getImgUrl() != null){
            currentPost.setImgUrl(post.getImgUrl());
        }

        if(post.getPostedDate() != null){
            currentPost.setPostedDate(post.getPostedDate());
        }

        if(post.getAuthor() != null){
            currentPost.setAuthor(
                    authorRepository.findById(post.getAuthor().getAuthorid())
                    .orElseThrow(() -> new ResourceNotFoundException("TEST"))
            );
        }

        return postRepository.save(currentPost);
    }

    @Transactional
    @Override
    public void delete(long id){
        postRepository.deleteById(id);
    }
}
