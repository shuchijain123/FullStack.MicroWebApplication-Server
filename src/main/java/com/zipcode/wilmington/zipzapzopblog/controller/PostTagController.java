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
import java.util.List;
import java.util.Optional;

@RestController
public class PostTagController {

    @Autowired
    TagService tagService;

    @GetMapping("/posts/{id}/tags")
    public ResponseEntity<Collection<Tag>> getAllTagsOnPost(@PathVariable Long postId){
        Optional<Post> post = tagService.findPost(postId);
        Collection<Tag> tagsOnPost = new ArrayList<>();
        tagsOnPost = post.get().getTags();

        return new ResponseEntity<>(tagsOnPost, HttpStatus.OK);
    }

    @GetMapping("/tags/{id}/posts")
    public ResponseEntity<Collection<Post>> getAllPostsByTag(@PathVariable Long tagId){
        Tag tag = tagService.getTag(tagId);
        Collection<Post> posts = tag.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


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
