package com.deepak.bookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.bookingservice.dto.SeatBookingDTO;
import com.deepak.bookingservice.entity.BookingHistory;
import com.deepak.bookingservice.service.BookingService;

@RestController
public class BookingController
{

   @Autowired
   private BookingService bookingService;


    @GetMapping("/bookHistory")
    public List<BookingHistory> confirmSeats(@RequestParam String userName)
    {
           return     bookingService.confirmSeats(userName);         
    }
    

    @PostMapping("/booking")
    public BookingHistory confirmSeats(@RequestBody SeatBookingDTO seatBookingDTO)
    {  	
    	return bookingService.confirmSeats(seatBookingDTO);   	    
    }


}
