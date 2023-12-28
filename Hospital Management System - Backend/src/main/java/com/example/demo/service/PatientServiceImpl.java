package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDoctorDao;
import com.example.demo.dao.PatientDao;
import com.example.demo.entity.BookingDoctor;
import com.example.demo.entity.Patient;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	PatientDao dao;
	@Autowired
	BookingDoctorDao bookingdao;
	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Optional<Patient> findById(int pid) {
		// TODO Auto-generated method stub
		return dao.findById(pid);
	}
	@Override
	public void saveorUpdate(Patient p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}
	@Override
	public void deleteById(int pid) {
		// TODO Auto-generated method stub
		dao.deleteById(pid);
	}
	@Override
	public Patient findPatientBypName(String pName) {
		// TODO Auto-generated method stub
		return dao.findPatientBypName(pName);
	}
	@Override
	public List<BookingDoctor> viewpatientAppointments(int pid) {
		// TODO Auto-generated method stub
		return bookingdao.viewpatientAppointments(pid);
	}
	@Override
	public Patient findPatientByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findPatientByUsername(username);
	}
	
	

}
