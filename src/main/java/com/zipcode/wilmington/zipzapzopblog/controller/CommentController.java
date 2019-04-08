package com.zipcode.wilmington.zipzapzopblog.controller;

import com.zipcode.wilmington.zipzapzopblog.model.Comment;
import com.zipcode.wilmington.zipzapzopblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class CommentController {

    private CommentService commentService;



    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        return new ResponseEntity<Comment>(commentService.show(id), HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity<Iterable<Comment>> getAllComments(){

        return new ResponseEntity<Iterable<Comment>>(commentService.index(), HttpStatus.OK);

    }



    @DeleteMapping("/deletecomment/{id}")
    public  ResponseEntity<Boolean> deleteComment(@PathVariable Long id){
        return new ResponseEntity<>(commentService.delete(id), HttpStatus.OK);
    }


    @PutMapping("/comment/{id}")
    public  ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody Comment comment) {

        return new ResponseEntity<>(commentService.edit(id, comment), HttpStatus.OK);
    }


    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String createNewComment(@Valid Comment comment,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/commentForm";

        } else {
            commentService.createComment(comment);
            return "redirect:/post/";
        }
    }
}
