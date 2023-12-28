package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.BookingDoctor;

public interface BookingDoctorService {
	public void save(BookingDoctor bd);
	public BookingDoctor viewAppointments(int pid);
	public void deleteById(int id);

}
