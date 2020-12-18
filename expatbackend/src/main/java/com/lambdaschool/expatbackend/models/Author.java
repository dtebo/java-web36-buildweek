package com.lambdaschool.expatbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;

    private String name;

    public Author() {
    }

    public Author(long authorid, String name) {
        this.authorid = authorid;
        this.name = name;
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

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", name='" + name + '\'' +
                '}';
    }
}
