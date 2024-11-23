package com.taxi.taxibooking.service;

import com.taxi.taxibooking.model.ContactForm;

import java.util.List;

public interface ContactFormService {

    public ContactForm saveContactFormService(ContactForm contactForm);
    public List<ContactForm> readAllContactService();
    public void deleteContact(int id);

}
