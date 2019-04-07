package com.zipcode.wilmington.zipzapzopblog.service;

import com.zipcode.wilmington.zipzapzopblog.model.User;
import com.zipcode.wilmington.zipzapzopblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User show(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public User create(User user){
        return userRepo.save(user);
    }

    public Boolean delete(Long id){
        userRepo.deleteById(id);
        return true;
    }


}
