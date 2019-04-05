package com.zipcode.wilmington.zipzapzopblog.model;


import javax.persistence.Entity;
import java.util.Collection;
import java.util.Date;

@Entity
public class Post {
    private Long id;
    private String body;
    private Date cretaeDate;
    private User user;
    private Collection<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCretaeDate() {
        return cretaeDate;
    }

    public void setCretaeDate(Date cretaeDate) {
        this.cretaeDate = cretaeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
