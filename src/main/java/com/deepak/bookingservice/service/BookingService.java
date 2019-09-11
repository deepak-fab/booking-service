package com.deepak.bookingservice.service;

import java.util.List;

import com.deepak.bookingservice.dto.SeatBookingDTO;
import com.deepak.bookingservice.entity.BookingHistory;

public interface BookingService {

	List<BookingHistory> confirmSeats(String userName);

	BookingHistory confirmSeats(SeatBookingDTO seatBookingDTO);

}
