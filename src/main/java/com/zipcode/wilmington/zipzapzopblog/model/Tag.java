package com.zipcode.wilmington.zipzapzopblog.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id", unique = false, nullable = false)
    private Long id;

    @Column(name = "key_word",unique = false, nullable = false)
    private String keyWord;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "tags")
    private Collection<Post> posts;

    public Tag(){
    }

    public Tag(String keyWord) {
        this.keyWord = keyWord;
    }

    public Tag(String keyWord, Collection<Post> posts) {
        this.keyWord = keyWord;
        this.posts = posts;
    }

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

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        if(posts!=null){
            this.posts = posts;
        }
    }

}
