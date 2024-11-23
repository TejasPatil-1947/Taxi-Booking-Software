package com.taxi.taxibooking.dao;

import com.taxi.taxibooking.model.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm,Integer> {

}
