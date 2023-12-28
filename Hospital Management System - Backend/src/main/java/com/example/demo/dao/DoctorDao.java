package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Doctor;


@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer>{
	Doctor findDoctorBydname(String dname);
	Doctor findDoctorByUsername(String username);
	
	
	  
	 

}

