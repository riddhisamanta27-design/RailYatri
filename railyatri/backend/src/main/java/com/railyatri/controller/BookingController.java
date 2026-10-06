package com.railyatri.controller;

import com.railyatri.model.Booking;
import com.railyatri.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{pnr}")
    public Booking getBooking(@PathVariable String pnr) {
        return bookingService.getBookingByPnr(pnr);
    }

    @DeleteMapping("/{pnr}")
    public boolean cancelBooking(@PathVariable String pnr) {
        return bookingService.cancelBooking(pnr);
    }
    
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
