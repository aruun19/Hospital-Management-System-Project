package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;

	@Repository
	public interface PatientDao extends JpaRepository<Patient, Integer>  
	{
		Patient findPatientBypName(String pName);
		Patient findPatientBypId(int pId);
		Patient findPatientByUsername(String username);
	}


