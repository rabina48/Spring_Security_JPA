package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.services.RegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private RegisterServices registerServices;

    @PostMapping("register")
    public Response addData(@RequestBody User user){
        return  registerServices.addData(user);
    }

}
