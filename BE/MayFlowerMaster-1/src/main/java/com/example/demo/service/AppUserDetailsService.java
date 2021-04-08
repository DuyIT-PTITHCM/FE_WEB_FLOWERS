package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.demo.entity.AdminFlower;
import com.example.demo.repository.AdminFlowerResository;


import java.util.ArrayList;
import java.util.List;


@Component
public class AppUserDetailsService implements UserDetailsService{
    @Autowired
    private AdminFlowerResository adminFlowerResository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminFlower user = adminFlowerResository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        
        user.getRoleFlowers().forEach(role -> {
        	
            authorities.add(new SimpleGrantedAuthority(role.getRoleadmin()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }
 
}
