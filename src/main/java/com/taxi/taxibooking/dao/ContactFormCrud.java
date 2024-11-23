package com.taxi.taxibooking.dao;

import com.taxi.taxibooking.model.ContactForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer> {


}
