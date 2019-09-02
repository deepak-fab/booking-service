package com.deepak.bookingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deepak.bookingservice.dto.SeatBookingDTO;
import com.deepak.bookingservice.entity.BookingHistory;
import com.deepak.bookingservice.repo.BookingServiceRepository;

@RestController
public class BookingController
{



    @Autowired
    private BookingServiceRepository repo;

    @GetMapping("/bookHistory")
    public List<BookingHistory> confirmSeats2(@RequestParam String userName)
    {
        
           return  repo.findByUserName(userName);
    
    }
    

    @PostMapping("/booking")
    public BookingHistory confirmSeats2(@RequestBody SeatBookingDTO seatBookingDTO)
    {
/*        ResponseEntity<BookingHistory> responseEntity = new RestTemplate().postForEntity("http://localhost:8100/bookseats",
        		seatBookingDTO, BookingHistory.class);*/
        
        ResponseEntity<BookingHistory> responseEntity = new RestTemplate().postForEntity("http://34.93.149.88:8100/bookseats",
        		seatBookingDTO, BookingHistory.class);
        
        BookingHistory bookingHistory = responseEntity.getBody();
        if (bookingHistory != null) {
            repo.save(bookingHistory);
        }
        return bookingHistory;
    
    }


}
