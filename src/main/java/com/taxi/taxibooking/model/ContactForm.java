package com.taxi.taxibooking.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "contactform")
public class ContactForm {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name can't be empty")
    @Size(min = 2, max = 30, message = "Invalid name size")
    private String name;

    @NotEmpty(message = "email can't be empty")
    @Size(min = 5, max = 50, message = "Invalid email size")
    private String email;

    @NotNull(message = "Phone number can't be empty")
    @Min(value = 1000000000,message = "Phone number must be at least 10 digits")
    @Max(value = 9999999999L,message = "Phone number must be at least 10 digits")
    private Long phone;

    @NotEmpty(message = "message can't be empty")
    @Size(min = 3, max = 500, message = "Invalid message size")
    private String message;

    public ContactForm() {
    }


    public ContactForm(String name, String email, Long phone, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", message='" + message + '\'' +
                '}';
    }
}

