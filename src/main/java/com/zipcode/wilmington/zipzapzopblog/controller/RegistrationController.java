package com.zipcode.wilmington.zipzapzopblog.controller;

import com.zipcode.wilmington.zipzapzopblog.service.UserService;

public class RegistrationController {

    private UserService service;

    public RegistrationController(UserService userService){
        this.service= userService;
    }

}
