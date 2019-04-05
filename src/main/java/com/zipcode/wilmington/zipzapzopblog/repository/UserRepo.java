package com.zipcode.wilmington.zipzapzopblog.repository;

import com.zipcode.wilmington.zipzapzopblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
