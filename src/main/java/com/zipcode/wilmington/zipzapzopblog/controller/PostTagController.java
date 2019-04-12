package com.zipcode.wilmington.zipzapzopblog.controller;

import com.zipcode.wilmington.zipzapzopblog.model.Post;
import com.zipcode.wilmington.zipzapzopblog.model.Tag;
import com.zipcode.wilmington.zipzapzopblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
public class PostTagController {

    @Autowired
    TagService tagService;

//    @GetMapping("/posts/{id}/tags")
//    public ResponseEntity<List<>>
//
//    @GetMapping("/tags/{id}/posts")

    @PostMapping("/posts/{postId}/tags/{tagId}")
    public ResponseEntity<Boolean> updatePostTag(@PathVariable Long postId, @PathVariable Long tagId) {
        Optional<Post> post = tagService.findPost(postId);
        Tag tag = tagService.getTag(tagId);

        Collection<Post> posts = new ArrayList<>();

        if(post.isPresent()){
            posts.add(post.get());
            tag.setPosts(posts);
        }
        tagService.update(tag);
        return new ResponseEntity<>(true, HttpStatus.OK);

    }

}
