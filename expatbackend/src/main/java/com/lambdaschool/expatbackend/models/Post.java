package com.lambdaschool.expatbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postid;

    private String title;
    private String body;
    private Date postedDate;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties(value = "post", allowSetters = true)
    private Author author;

    public Post() {
    }

    public Post(String title, String body, Date postedDate, String imgUrl, Author author) {
        this.title = title;
        this.body = body;
        this.postedDate = postedDate;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
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
                ", body='" + body + '\'' +
                ", postedDate=" + postedDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", author=" + author +
                '}';
    }
}
