package com.example.demo.services;

import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.Login;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.repository.UserDaoImpl;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServices implements UserDetailsService {

    @Autowired
    private LoginServices loginServices;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response loginData(Login login) {

        User user = userRepo.findByEmail(login.getEmail());
        if (user == null) {
            return new Response(false, "Email cannot be null!!");

        }else if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            return new Response(false, "Password Mismatch!!");

        } else {
            return new Response(true, "login Success!!");
        }
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =userRepo.findByEmail(s);
        return new CustomUserDetails();
    }
}


