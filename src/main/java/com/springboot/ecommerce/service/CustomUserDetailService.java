package com.springboot.ecommerce.service;

import com.springboot.ecommerce.model.CustomUserDetail;
import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    private String email;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findUserByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User Not found"));
        return user.map(CustomUserDetail::new).get();
    }
}
