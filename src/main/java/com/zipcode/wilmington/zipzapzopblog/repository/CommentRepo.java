package com.zipcode.wilmington.zipzapzopblog.repository;

import com.zipcode.wilmington.zipzapzopblog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
