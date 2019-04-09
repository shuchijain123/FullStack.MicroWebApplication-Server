package com.zipcode.wilmington.zipzapzopblog.controller;

import com.zipcode.wilmington.zipzapzopblog.model.Post;
import com.zipcode.wilmington.zipzapzopblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service){
        this.service = service;
    }
    @GetMapping(value = "/posts")
    public ResponseEntity<List<Post>> index(){ return new ResponseEntity<>(service.findAllOrderByDate(), HttpStatus.OK);}

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<Post> show(@PathVariable Long id){
       return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping(value = "/posts")
    public ResponseEntity<Post> create(@RequestBody Post post){
        return new ResponseEntity<>(service.create(post), HttpStatus.CREATED);
    }

    @PutMapping(value = "/posts/update")
    public ResponseEntity<Post>update(@PathVariable Long id,@RequestBody Post post){
        return new ResponseEntity<>(service.update(post), HttpStatus.OK);
    }
    @DeleteMapping(value = "/posts/delete")
    public ResponseEntity<Boolean>destroy(@PathVariable Long id){
           return new ResponseEntity<>(service.delete(id), HttpStatus.OK);}




}
