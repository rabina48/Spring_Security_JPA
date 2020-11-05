package com.example.demo.services;

import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response addData(User user) {
        Object data = userRepo.save(user);

        if (user.getEmail() == null) {
            return new Response(false, "Email cannot be null!");
        }

        User user1 = userRepo.findByEmail(user.getEmail());
        if (user.getEmail().equals(user1)) {

            return new Response(true, "Already exist!");
        } else{
            String  password = user.getPassword();
            String encodedPassword =passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            return new Response(true, "  You are Registered!", data);
        }

    }
}
