package com.taxi.taxibooking.service;

import com.taxi.taxibooking.dao.BookingFormCrud;
import com.taxi.taxibooking.model.BookingForm;
import com.taxi.taxibooking.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingFormServiceImpl implements BookingFormService{

    @Autowired
    private BookingFormCrud bookingFormCrud;

    @Override
    public BookingForm saveBookingFormService(BookingForm bookingForm) {
        return bookingFormCrud.save(bookingForm);
    }

    @Override
    public List<BookingForm> readAllBookingService() {
        return bookingFormCrud.findAll();
    }

    @Override
    public void deleteBookingService(int id) {
        bookingFormCrud.deleteById(id);
    }

}
