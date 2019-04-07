package com.zipcode.wilmington.zipzapzopblog.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String keyWord;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Collection<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
//
//    public Collection<Post> getPosts() {
//        return posts;
//    }

//    public void setPosts(Collection<Post> posts) {
//        this.posts = posts;
//    }




}
