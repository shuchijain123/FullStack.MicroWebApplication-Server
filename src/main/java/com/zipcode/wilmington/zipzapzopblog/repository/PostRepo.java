package com.zipcode.wilmington.zipzapzopblog.repository;

import com.zipcode.wilmington.zipzapzopblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
