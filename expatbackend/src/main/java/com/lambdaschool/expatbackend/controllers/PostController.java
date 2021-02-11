package com.lambdaschool.expatbackend.controllers;

import com.lambdaschool.expatbackend.models.Post;
import com.lambdaschool.expatbackend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts", produces = "application/json")
    public ResponseEntity<?> listAllPosts(){
        List<Post> allPosts = postService.findAllPosts();

        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping(value = "/post/{substr}", produces = "application/json")
    public ResponseEntity<?> findPostByPostTitle(@PathVariable String substr){
        Post post = postService.findPostByTitle(substr);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
