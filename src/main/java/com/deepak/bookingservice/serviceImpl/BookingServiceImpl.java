package com.deepak.bookingservice.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deepak.bookingservice.dto.SeatBookingDTO;
import com.deepak.bookingservice.entity.BookingHistory;
import com.deepak.bookingservice.exception.ResourceNotFoundException;
import com.deepak.bookingservice.repo.BookingServiceRepository;
import com.deepak.bookingservice.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingServiceRepository repo;
	
	
	@Override
	public List<BookingHistory> confirmSeats(String userName) {
		List<BookingHistory>  history =  repo.findByUserName(userName);
	    
	    if (!history.isEmpty()) {
	    	return history;
	    }else {   	
	    throw  new ResourceNotFoundException("No User History Found");
	    }
	}


	@Override
	public BookingHistory confirmSeats(SeatBookingDTO seatBookingDTO) {
		ResponseEntity<BookingHistory> responseEntity; 
		
		  try {
/*			responseEntity = new RestTemplate().postForEntity("http://localhost:8100/bookseats",
						seatBookingDTO, BookingHistory.class);	*/	
			
			responseEntity = new RestTemplate().postForEntity("http://34.93.149.88:8100/bookseats",
					seatBookingDTO, BookingHistory.class);
			
		  }catch (ResourceNotFoundException e) {
			  throw  new ResourceNotFoundException("Error while booking"); 
		}


/*			ResponseEntity<BookingHistory> responseEntity = new RestTemplate().postForEntity("http://34.93.149.88:8100/bookseats",
					seatBookingDTO, BookingHistory.class);*/
			
			BookingHistory bookingHistory = responseEntity.getBody();
			if (bookingHistory != null) {
			    repo.save(bookingHistory);
			}
			return bookingHistory;
	}

}
