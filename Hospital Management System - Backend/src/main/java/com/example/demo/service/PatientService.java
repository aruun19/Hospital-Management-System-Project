package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Patient;
@Service
	public interface PatientService 
	{
		public List<Patient> findAll();
		public Optional<Patient> findById(int pid);
		public void saveorUpdate(Patient p);
		public void deleteById(int pid);
		Patient findPatientBypName(String pName);
		public List<BookingDoctor> viewpatientAppointments(int pid);
		Patient findPatientByUsername(String username);
		
	}


