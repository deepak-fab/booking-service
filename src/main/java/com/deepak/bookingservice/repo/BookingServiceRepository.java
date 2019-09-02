package com.deepak.bookingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.bookingservice.entity.BookingHistory;

public interface BookingServiceRepository extends JpaRepository<BookingHistory, Integer>
{

	List<BookingHistory>  findByUserName(String userName);
	
}
