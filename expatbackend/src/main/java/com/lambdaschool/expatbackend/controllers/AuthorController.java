package com.lambdaschool.expatbackend.controllers;

import com.lambdaschool.expatbackend.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors", produces = "application/json")
    public ResponseEntity<?> listAllAuthors(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
