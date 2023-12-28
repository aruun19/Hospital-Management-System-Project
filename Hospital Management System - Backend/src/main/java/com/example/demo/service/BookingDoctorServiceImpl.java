package com.example.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDoctorDao;
import com.example.demo.entity.BookingDoctor;

@Service
public class BookingDoctorServiceImpl implements BookingDoctorService {
	@Autowired
	BookingDoctorDao dao;

	@Override
	public void save(BookingDoctor bd) {
		dao.save(bd);
		
	}

	@Override
	public BookingDoctor viewAppointments(int pid) {
		
		return dao.viewAppointments(pid);
	}

	@Override
	public void deleteById(int id) {
		 dao.deleteById(id);
		
	}

}
