package com.taxi.taxibooking.service;

import com.taxi.taxibooking.dao.ContactFormCrud;
import com.taxi.taxibooking.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFormServiceImpl implements ContactFormService{

    @Autowired
    private ContactFormCrud contactFormCrud;

    @Override
    public ContactForm saveContactFormService(ContactForm contactForm) {

    return contactFormCrud.save(contactForm);

    }

    @Override
    public List<ContactForm> readAllContactService() {
        return contactFormCrud.findAll();
    }

    @Override
    public void deleteContact(int id) {
        contactFormCrud.deleteById(id);
    }

}
