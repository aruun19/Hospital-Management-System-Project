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

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;
    @Autowired
    AdminDao dao;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Admin adminData) {
        System.out.println("Received a login request for admin: " + adminData.getusername());
        Map<String,String> response=new HashMap<String,String>();

        Admin admin = service.findByUsername(adminData.getusername());

        if (admin.getAdminpassword().equals(adminData.getAdminpassword())) {
            System.out.println("Admin login successful: " + admin);

            Admin sendadmin = new Admin();
            
            response.put("status", "success");
    		response.put("message", "Admin Successfully login!!");
    		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK); 
        } else {
            System.out.println("Admin login failed for: " + adminData.getusername());
            response.put("status", "failure");
    		response.put("message", "Admin data not found!");
    		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
        }
    }
}

