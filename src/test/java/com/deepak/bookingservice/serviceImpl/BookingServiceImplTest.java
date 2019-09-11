package com.deepak.bookingservice.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deepak.bookingservice.entity.BookingHistory;
import com.deepak.bookingservice.exception.ResourceNotFoundException;
import com.deepak.bookingservice.repo.BookingServiceRepository;
import com.deepak.bookingservice.service.BookingService;

@RunWith(MockitoJUnitRunner.class)

public class BookingServiceImplTest {

	

	
	@Mock
	private BookingHistory bookingHistory;
	
	@Mock
	private BookingServiceRepository repo;
	
	@Mock
	List<BookingHistory>  mockHistory;
	
	@InjectMocks
	private BookingServiceImpl bookingService;
	
	List<BookingHistory>  history ;
	
	@Before
	public void setUp() {
	  history  =  new ArrayList<>();	  
	}
	
	
	@Test
	public void testConfirmSeatsString() {
		
		given(repo.findByUserName("Deepak")).willReturn(mockHistory);
		
		List<BookingHistory> response = bookingService.confirmSeats("Deepak");
		
		assertNotNull(response);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testConfirmSeatsException() {
		given(repo.findByUserName("Deepak")).willReturn(history);	
		bookingService.confirmSeats("Deepak");
	}

}
