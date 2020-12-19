package com.lambdaschool.expatbackend.controllers;

import com.lambdaschool.expatbackend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts", produces = "application/json")
    public ResponseEntity<?> listAllPosts(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
