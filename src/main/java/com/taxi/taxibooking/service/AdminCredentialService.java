package com.taxi.taxibooking.service;

public interface AdminCredentialService {

    public String checkAdminCredentials(String oldUsername,String oldPassword);

    public String updateAdminCredentials(String oldUsername, String newUsername,String newPassword );
}
