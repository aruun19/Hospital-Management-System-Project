package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDoctorDao;
import com.example.demo.dao.DoctorDao;
import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Doctor;


@Service
public class DoctorServiceImpl implements DoctorService{
	 @Autowired
	 DoctorDao dao;
	 
	 @Autowired
		BookingDoctorDao bookingdao;
		@Override
		public List<Doctor> findAll() {
			return dao.findAll();
		}
		@Override
		public Optional<Doctor> findById(int id) {
			return dao.findById(id);
		}
		@Override
		public void saveorUpdate(Doctor d) {
			dao.save(d);
		}

		@Override
		public void deleteById(int id) {
			dao.deleteById(id);
			
		}
		@Override
		public Doctor findDoctorBydname(String dname) {
			return dao.findDoctorBydname(dname);
		}
		
		  @Override 
		  public List<BookingDoctor> viewdoctorAppointments(int did) { 
		  return bookingdao.viewdoctorAppointments(did); 
		  }
		@Override
		public Doctor findDoctorByUsername(String username) {
			return dao.findDoctorByUsername(username);
		}
		

}

