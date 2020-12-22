package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.exceptions.ResourceFoundException;
import com.lambdaschool.expatbackend.exceptions.ResourceNotFoundException;
import com.lambdaschool.expatbackend.models.Author;
import com.lambdaschool.expatbackend.models.Post;
import com.lambdaschool.expatbackend.repository.AuthorRepository;
import com.lambdaschool.expatbackend.repository.PostRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Author> findAllAuthors(){
        List<Author> authors = authorRepository.findAll();

        return authors;
    }

    @Override
    public Author findByName(String n) {
        Author author = authorRepository.findByNameContainingIgnoreCase(n);

        if(author != null) {
            return author;
        }
        else{
            throw new ResourceNotFoundException("Author " + n + " Not Found!");
        }
    }

    @Transactional
    @Override
    public Author save(Author author){
        Author newAuthor = new Author();

        if(author.getAuthorid() != 0){
            authorRepository.findById(author.getAuthorid())
                    .orElseThrow(() -> new ResourceNotFoundException("Author " + author.getAuthorid() + " Not Found!"));

            newAuthor.setAuthorid(author.getAuthorid());
        }

        newAuthor.setName(author.getName());

        newAuthor.getPosts().clear();
        for(Post p : author.getPosts()){
            Post newPost = postRepository.findById(p.getPostid())
                    .orElseThrow(() -> new ResourceNotFoundException("Post " + p.getPostid() + " Not Found!"));

            newPost.setAuthor(
                    newAuthor
            );

            newAuthor.getPosts().add(newPost);
        }

        return authorRepository.save(newAuthor);
    }

    @Transactional
    @Override
    public Author update(Author author, long id){
        Author currentAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author " + id + " Not Found!"));

        if(author.getName() != null){
            currentAuthor.setName(author.getName());
        }

        if(author.getPosts().size() > 0){
            currentAuthor.getPosts().clear();

            for(Post p : author.getPosts()){
                Post post = new Post();
                post.setTitle(p.getTitle());
                post.setBody(p.getBody());
                post.setImgUrl(p.getImgUrl());
                post.setPostedDate(p.getPostedDate());
                post.setAuthor(p.getAuthor());
                currentAuthor.getPosts().add(post);
            }
        }

        return authorRepository.save(currentAuthor);
    }

    @Transactional
    @Override
    public void delete(long id){
        authorRepository.deleteById(id);
    }
}
