package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.dao.PaymentDao;
import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Payment")
public class PaymentController {
	 @Autowired
	  PaymentService service;
	  
	  @Autowired
	  PaymentDao dao;
	  
	  
	  @GetMapping("/list")
	    public ResponseEntity<List<Payment>> findAll()
	    {
	        return new ResponseEntity<List<Payment>>(this.service.findALL(), HttpStatus.OK);
	    }
	  
	  @GetMapping("/find/{paymentId}")
	    public ResponseEntity<?> getUserByID(@PathVariable int paymentId)
	    {
	        if(this.service.findpatientBypaymentId(paymentId).isPresent())
	        {
	            return new ResponseEntity<Payment>(this.service.findpatientBypaymentId(paymentId).get(),HttpStatus.OK);
	        }
	        else
	        {
	            return new ResponseEntity<String>("User Id  not found!",HttpStatus.NOT_FOUND);
	        }
	    }
	    
	 @PostMapping("/addpayment")
	    public ResponseEntity<Map<String, Object>> pay(@RequestBody Payment payment) {
	    	
	    	// Log the complete request body
	        System.out.println("Request Body: " + payment.toString());
	       
	    	this.service.savepayment(payment);
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", "success");
	        response.put("message", "Payment registered!!");
	        
	              
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }
	  
	     
	    @DeleteMapping("/delete/{paymentId}")
	    public ResponseEntity<Map<String, String>> deletePayment(@PathVariable int paymentId) {
	        System.out.println("Received a request to delete payment with ID: " + paymentId);
	        
	        
	        service.deletePayment(paymentId);
	        Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Payment deleted!!");
           
	        System.out.println("Payment deleted for ID: " + paymentId);
	        
	        return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
	    }    

}
