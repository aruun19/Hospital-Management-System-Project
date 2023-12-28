package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DoctorDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.DoctorAppointments;
import com.example.demo.entity.Patient;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("doct")
public class DoctorController {
	@Autowired
	DoctorService service;
	@Autowired
	DoctorDao dao;
	@Autowired
	PatientService pservice;
	@GetMapping("/list")
	public ResponseEntity<List<Doctor>>findAll()
	{
		return new ResponseEntity<List<Doctor>>(this.service.findAll(), HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getDoctorById(@PathVariable int id)
	{
		if(this.service.findById(id).isPresent())
		{
			return new ResponseEntity<Doctor>(this.service.findById(id).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Doctor Id  not found!",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/plusdoct")
    public ResponseEntity<Map<String,String>> saveDoctor(@RequestBody Doctor d)
    {
        try
        {
        	
            Optional<Doctor> existingdoct=this.dao.findById(d.getdId());
            if(existingdoct.isEmpty())
            {
                
        
            this.service.saveorUpdate(d);
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Doctor data added!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
            }
            else
            {
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Doctor already  found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Doctor not saved!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
        }
    }
	@PutMapping("/update")
    public ResponseEntity<Map<String,String>> updateDoct(@RequestBody Doctor d)
    {
        try
        {
            if(this.dao.findById(d.getdId()).isPresent())
            {
               Doctor existingDoct=this.dao.findById(d.getdId()).get();
               existingDoct.setDname(d.getDname());
               existingDoct.setSpecilization(d.getSpecilization());
               existingDoct.setDepartment(d.getDepartment());
               existingDoct.setCity(d.getCity());
               existingDoct.setContactno(d.getContactno());

            this.service.saveorUpdate(d);
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Doctor data updated!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
            }
            else
            {
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Doctor data  not found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Doctor not updated!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
        }
    }
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,String>> deleteById(@PathVariable int id)
	{
		try
		{
			this.service.deleteById(id);
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "success");
			response.put("message", "Doctor data deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Doctor data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}

}
	@GetMapping("/search/{dname}")
    public ResponseEntity<Doctor> geEmployeeByename(@PathVariable String dname) {
        System.out.println("Received a request to get Doctor by dname: " + dname);

        Doctor doct = service.findDoctorBydname(dname);
        if (doct == null) {
            System.out.println("Doctor not found for username: " + dname);
           
        }

        System.out.println("Returning Doctor for username: " + doct);
        return new ResponseEntity<>(doct, HttpStatus.OK);
    }
	
	  @GetMapping("/viewdoctorAppointments/{did}") 
	  public ResponseEntity<List<DoctorAppointments>> viewdoctorAppointments(@PathVariable int did) {
	  List<BookingDoctor> booking=service.viewdoctorAppointments(did);
	  System.out.println("Booking Details:"+booking);
	  List<DoctorAppointments> docAppList=new ArrayList<>();
	  DoctorAppointments doctorappointments=null;
	  for (BookingDoctor bookingDoctor : booking) {
		  Optional<Patient> patientDetails=pservice.findById(bookingDoctor.getPatientId());
		  doctorappointments=new DoctorAppointments();
		  //doctorappointments.setBookingid(bookingDoctor.getBookingId());
		  doctorappointments.setBookingid(bookingDoctor.getBookingId());
		  doctorappointments.setPatient(patientDetails.get());
		  docAppList.add(doctorappointments);
	}
	  
	  return new ResponseEntity<List<DoctorAppointments>>(docAppList, HttpStatus.OK);
	  
	  }
	  
	  @PostMapping("/login")
	    public ResponseEntity<Map<String,String>> loginDoctor(@RequestBody Doctor doctorData) {
	        System.out.println("Received a login request for doctor: " + doctorData.getUsername());
	        Map<String,String> response=new HashMap<String,String>();

	        Doctor doctor = service.findDoctorByUsername(doctorData.getUsername());
	       // System.out.println("Doctor Details:"+doctor);

	        if (doctor.getPassword().equals(doctorData.getPassword())) {
	            System.out.println("Doctor login successful: " + doctor);

	            //Admin sendadmin = new Admin();
	            
	            response.put("status", "success");
	    		response.put("message", "Doctor Successfully login!!");
	    		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK); 
	        } else {
	            System.out.println("Doctor login failed for: " + doctorData.getUsername());
	            response.put("status", "failure");
	    		response.put("message", "Doctor data not found!");
	    		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
	        }
	    }
	  

	  
}

