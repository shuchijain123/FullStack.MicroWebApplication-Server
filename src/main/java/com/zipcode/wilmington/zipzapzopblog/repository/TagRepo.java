package com.zipcode.wilmington.zipzapzopblog.repository;

import com.zipcode.wilmington.zipzapzopblog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag,Long> {
}
