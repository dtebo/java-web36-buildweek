package com.lambdaschool.expatbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postid;

    private String title;
    private String description;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties(value = "post", allowSetters = true)
    private Author author;

    public Post() {
    }

    public Post(String title, String description, String imgUrl, Author author) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.author = author;
    }

    public long getPostid() {
        return postid;
    }

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", author=" + author +
                '}';
    }
}
