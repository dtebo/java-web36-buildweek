package com.lambdaschool.expatbackend.controllers;

import com.lambdaschool.expatbackend.models.Author;
import com.lambdaschool.expatbackend.services.AuthorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors", produces = "application/json")
    @ApiOperation(value = "returns all authors",
      response = Author.class,
      responseContainer = "List")
    public ResponseEntity<?> listAllAuthors(){
        List<Author> authorList = authorService.findAllAuthors();

        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping(value = "/author/{name}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable String name){
        Author author = authorService.findByName(name);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping(value = "/author",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewAuthor(@Valid @RequestBody Author newAuthor) throws URISyntaxException{
        newAuthor = authorService.save(newAuthor);

        HttpHeaders authorHeaders = new HttpHeaders();
        URI authorURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAuthor.getAuthorid())
                .toUri();
        authorHeaders.setLocation(authorURI);

        return new ResponseEntity<>(newAuthor, authorHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/author/{authorid}",
                consumes = {"application/json"},
                produces = {"application/json"})
    public ResponseEntity<?> updateAuthor(@Valid @RequestBody Author author, long id){
        author.setAuthorid(id);
        authorService.save(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
