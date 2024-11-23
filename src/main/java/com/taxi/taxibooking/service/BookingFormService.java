package com.taxi.taxibooking.service;

import com.taxi.taxibooking.model.BookingForm;
import com.taxi.taxibooking.model.ContactForm;

import java.util.List;

public interface BookingFormService {

    public BookingForm saveBookingFormService(BookingForm bookingForm);
    public List<BookingForm> readAllBookingService();
    public void deleteBookingService(int id);

}

