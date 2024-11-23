package com.taxi.taxibooking.config;

import com.taxi.taxibooking.dao.AdminDao;
import com.taxi.taxibooking.model.Admin;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init()
    {
        long count = adminDao.count();
        if(count == 0){

          Admin admin =  new Admin();
          admin.setUsername("admin");
          admin.setPassword(passwordEncoder.encode("admin123"));

          adminDao.save(admin);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> byUsername = adminDao.findByUsername(username);
        Admin admin =  byUsername.orElseThrow(()-> new UsernameNotFoundException("admin doesn't exist"));
        return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();
    }
}
