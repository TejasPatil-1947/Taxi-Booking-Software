package com.taxi.taxibooking.dao;

import com.taxi.taxibooking.model.ServiceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceFormCrud extends JpaRepository<ServiceForm, Integer> {
}
