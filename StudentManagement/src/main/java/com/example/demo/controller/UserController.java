package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.services.LoginServices;
import com.example.demo.services.RegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RegisterServices registerServices;

    @Autowired
    private LoginServices loginServices;


    @PostMapping("users/register")
    public Response addData(@RequestBody User user){
        return  registerServices.addData(user);
    }



    @PostMapping("users/login")
    public Response login(@RequestBody Login login){
       return loginServices.loginData(login);
    }


    @GetMapping("admin/allData")
    public Response<List<User>> getAllData(@RequestBody User user){
       return registerServices.getAllData();
    }

}
