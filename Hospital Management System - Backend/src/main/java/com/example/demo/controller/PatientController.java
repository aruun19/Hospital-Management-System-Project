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

import com.example.demo.dao.PatientDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.DoctorAppointments;
import com.example.demo.entity.Patient;
import com.example.demo.entity.PatientAppointments;

import com.example.demo.service.DoctorService;
import com.example.demo.service.EmailService;
import com.example.demo.service.PatientService;



@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("Patient")
public class PatientController {
	@Autowired
	PatientService service;
	@Autowired
	PatientDao dao;
	@Autowired
	DoctorService dservice;
	@Autowired
	private EmailService emailService;
	@GetMapping("/list")
	public ResponseEntity<List<Patient>>findAll()
	{
		System.out.println("Returning all Patient data:");
		return new ResponseEntity<List<Patient>>(this.service.findAll(), HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getPatientById(@PathVariable int id)
	{
		if(this.service.findById(id).isPresent())
		{
			System.out.println("Returning patient for ID: " + id);
			return new ResponseEntity<Patient>(this.service.findById(id).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Patient Id not found!",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/addpatient")
    public ResponseEntity<Map<String,String>> saveProduct(@RequestBody Patient p)
    {
        try
        {
            Optional<Patient> existingproduct=this.dao.findById(p.getpId());
            if(existingproduct.isEmpty())
            {
                
        
            this.service.saveorUpdate(p);
            System.out.println("Patient data added successfully: " + existingproduct);
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Patient data added Successfully!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
            }
            else
            {
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Patient already found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Patient not updated!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
        }
    }
	@PutMapping("/update")
    public ResponseEntity<Map<String,String>> updatePatient(@RequestBody Patient p)
    {
        try
        {
            if(this.dao.findById(p.getpId()).isPresent())
            {
                Patient existingPatient=this.dao.findById(p.getpId()).get();
                existingPatient.setpName(p.getpName());
                existingPatient.setDiseaseName(p.getDiseaseName());
                existingPatient.setGender(p.getGender());
                existingPatient.setContactNumber(p.getContactNumber());
                existingPatient.setAddress(p.getAddress());
                

            this.service.saveorUpdate(p);
            System.out.println("Patient data updated successfully: " + existingPatient);
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Patient data updated Successfully!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
            }
            else
            {
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Patient data not found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Patient not updated!!");
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
			response.put("message", "Patient data deleted Successfully!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Patient data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/search/{pName}")
    public ResponseEntity<Patient> getPatientBypName(@PathVariable String pName) {
        System.out.println("Received a request to get patient by pName: " + pName);

        Patient patient = service.findPatientBypName(pName);
        if (patient == null) {
            System.out.println("Patient not found for pName: " + pName);
            
        }

        System.out.println("Returning patient for pName: " + patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
	
	@GetMapping("/viewpatientAppointments/{pid}") 
	  public ResponseEntity<List<PatientAppointments>> viewpatientAppointments(@PathVariable int pid) {
	  List<BookingDoctor> booking=service.viewpatientAppointments(pid);
	  List<PatientAppointments> patiAppList=new ArrayList<>();
	  PatientAppointments patientappointments=null;
	  for (BookingDoctor bookingDoctor : booking) {
		  Optional<Doctor> doctorDetails=dservice.findById(bookingDoctor.getDoctorId());
		  patientappointments=new PatientAppointments();
		  patientappointments.setBookingid(bookingDoctor.getBookingId());
		  patientappointments.setDoctor(doctorDetails.get());
		  patiAppList.add(patientappointments);
	}
	  
	  return new ResponseEntity<List<PatientAppointments>>(patiAppList, HttpStatus.OK);
	  
	  }
	@PostMapping("/signup")
	public ResponseEntity<Map<String,String>> singup(@RequestBody Patient patient)
	{
		this.service.saveorUpdate(patient);
		Map<String,String> response=new HashMap<String,String>();
		response.put("status", "success");
		response.put("message", "Patient registered!!");
		emailService.sendEmail(patient.getEmail(), "Registration Confirmation!", "Patient registerd successfully: "+patient.getpName());
	return new ResponseEntity<Map<String,String>>(response,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginDoctor(@RequestBody Patient patientData) {
        System.out.println("Received a login request for Patient: " + patientData.getUsername());
        Map<String,String> response=new HashMap<String,String>();

        Patient patient = service.findPatientByUsername(patientData.getUsername());
       // System.out.println("Doctor Details:"+doctor);

        if (patient.getPassword().equals(patientData.getPassword())) {
            System.out.println("Patient login successful: " + patient);

            //Admin sendadmin = new Admin();
            
            response.put("status", "success");
    		response.put("message", "Patient Successfully login!!");
    		response.put("pid", Integer.toString(patient.getpId()));
    		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK); 
        } else {
            System.out.println("Patient login failed for: " + patientData.getUsername());
            response.put("status", "failure");
    		response.put("message", "Patient data not found!");
    		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
        }
    }
  


}