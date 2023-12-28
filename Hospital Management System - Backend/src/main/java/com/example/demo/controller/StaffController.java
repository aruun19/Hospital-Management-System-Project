package com.example.demo.controller;

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

import com.example.demo.dao.StaffDao;
import com.example.demo.entity.Staff;
import com.example.demo.service.StaffService;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("Staff")
public class StaffController {
	@Autowired
	StaffService service;
	@Autowired
	StaffDao dao;
	@GetMapping("/list")
	public ResponseEntity<List<Staff>>findAll()
	{
		System.out.println("Returning all Staff data:");
		return new ResponseEntity<List<Staff>>(this.service.findAll(), HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id)
	{
		if(this.service.findById(id).isPresent())
		{
			System.out.println("Returning staff for ID: " + id);
			return new ResponseEntity<Staff>(this.service.findById(id).get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Staff Id not found!",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/addstaff")
    public ResponseEntity<Map<String,String>> saveProduct(@RequestBody Staff s)
    {
        try
        {
            Optional<Staff> existingproduct=this.dao.findById(s.getsId());
            if(existingproduct.isEmpty())
            {
                
        
            this.service.SaveorUpdate(s);
            System.out.println("Staff data added successfully: " + existingproduct);
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Staff data added Successfully!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
            }
            else
            {
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Staff already found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Staff not updated!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
        }
    }
	@PutMapping("/update")
    public ResponseEntity<Map<String,String>> updateStaff(@RequestBody Staff s)
    {
        try
        {
            if(this.dao.findById(s.getsId()).isPresent())
            {
                Staff existingStaff=this.dao.findById(s.getsId()).get();
                existingStaff.setsName(s.getsName());
                existingStaff.setExp(s.getExp());
                existingStaff.setDoj(s.getDoj());
                existingStaff.setContact(s.getContact());
                existingStaff.setAddress(s.getAddress());
                existingStaff.setJobrole(s.getJobrole());
                existingStaff.setQualification(s.getQualification());
                existingStaff.setSalary(s.getSalary());

            this.service.SaveorUpdate(s);
            System.out.println("Staff data updated successfully: " + existingStaff);
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "success");
            response.put("message", "Staff data updated Successfully!!");
            return new ResponseEntity<Map<String,String>>(response, HttpStatus.CREATED);
            }
            else
            {
                Map<String,String> response=new HashMap<String,String>();
                response.put("status", "failed");
                response.put("message", "Staff data not found!!");
                return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e1)
        {
            Map<String,String> response=new HashMap<String,String>();
            response.put("status", "failed");
            response.put("message", "Staff not updated!!");
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
			response.put("message", "Staff data deleted Successfully!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			Map<String,String> response=new HashMap<String,String>();
			response.put("status", "failed");
			response.put("message", "Staff data not deleted!!");
			return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/search/{sName}")
    public ResponseEntity<Staff> getStaffBysName(@PathVariable String sName) {
        System.out.println("Received a request to get staff by sName: " + sName);

        Staff staff = service.findStaffBysName(sName);
        if (staff == null) {
            System.out.println("staff not found for sName: " + sName);
            
        }

        System.out.println("Returning staff for sName: " + staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
	
	

}
