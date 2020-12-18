package com.lambdaschool.expatbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;

    private String name;

    @OneToMany(mappedBy = "author",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonIgnoreProperties(value = "author", allowSetters = true)
    private List<Post> posts = new ArrayList<>();

    public Author() {
    }

    public Author(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
