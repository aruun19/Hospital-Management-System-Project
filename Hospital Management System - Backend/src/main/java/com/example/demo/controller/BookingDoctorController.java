package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Doctor;
import com.example.demo.service.BookingDoctorService;
import com.example.demo.service.DoctorService;

import org.springframework.web.filter.CorsFilter; 
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("BookingDoctor")

public class BookingDoctorController {
	@Autowired
	BookingDoctorService service;
	
	@Autowired
	DoctorService dservice;
	
	
	@PostMapping("/savebooking")
    public ResponseEntity<Map<String,String>> saveDoctorBooking(@RequestBody BookingDoctor bd)
    {
        try
        {
        	    
        
        
            this.service.save(bd);
    
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Booked Doctor Sucessfuly!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);

        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Doctor not Booked!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
        }
    }
	@DeleteMapping("/delete/{bookingid}")
	public ResponseEntity<Map<String,String>> deleteById(@PathVariable int bookingid)
	{
		try
		{
			this.service.deleteById(bookingid);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", " Booking  deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Booking data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}

}
}
