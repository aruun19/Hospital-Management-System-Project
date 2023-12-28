package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Doctor;

public interface DoctorService {
	public List<Doctor>findAll();
	public Optional<Doctor>findById(int id);
	public void saveorUpdate(Doctor d);
	public void deleteById(int id);
	Doctor findDoctorBydname(String dname);
	public List<BookingDoctor> viewdoctorAppointments(int did);
	Doctor findDoctorByUsername(String username);

}
