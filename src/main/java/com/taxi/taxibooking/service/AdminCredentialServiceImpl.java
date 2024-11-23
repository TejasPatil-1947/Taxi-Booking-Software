package com.taxi.taxibooking.service;

import com.taxi.taxibooking.dao.AdminDao;
import com.taxi.taxibooking.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminCredentialServiceImpl implements AdminCredentialService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String checkAdminCredentials(String oldUsername, String oldPassword) {
        Optional<Admin> byUsername= adminDao.findByUsername(oldUsername);
        if(byUsername.isPresent()){
            Admin admin = byUsername.get();
            boolean matches = passwordEncoder.matches(oldPassword,admin.getPassword());
            if(matches){
                return "SUCCESS";
            }else {
                return "Wrong old Credentials";
            }
        }else {
            return "Wrong old  Credentials";
        }
    }

    @Override
    public String updateAdminCredentials(String oldUsername, String newUsername, String newPassword) {
      int updateCredentials =  adminDao.updateCredentials(newUsername,passwordEncoder.encode(newPassword),oldUsername);
      if(updateCredentials == 1){
          return "CREDENTIALS UPDATED SUCCESSFULLY";
      }else {
          return "FAILED TO UPDATE CREDENTIALS";
      }
    }
}
