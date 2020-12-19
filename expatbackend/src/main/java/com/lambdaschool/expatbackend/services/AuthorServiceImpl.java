package com.lambdaschool.expatbackend.services;

import com.lambdaschool.expatbackend.models.Author;
import com.lambdaschool.expatbackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author save(Author author){
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public void delete(long id){
        authorRepository.deleteById(id);
    }
}
