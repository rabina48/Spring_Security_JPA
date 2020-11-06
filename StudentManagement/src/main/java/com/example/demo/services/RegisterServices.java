package com.example.demo.services;

import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response<User> addData(User user) {
        User user1 = userRepo.findByEmail(user.getEmail());

        if (user.getEmail() == null) {
            return new Response(false, "Email cannot be null!");
        }

        else if (user1 == null) {
            String password = user.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            return new Response(true, "Added Success!", userRepo.save(user));


        } else {

            return new Response(true, "Already exist email!!");

        }

    }


    public Response<List<User>> getAllData() {
        return new Response<>(true,"sucess!", userRepo.findAll());
    }


}
