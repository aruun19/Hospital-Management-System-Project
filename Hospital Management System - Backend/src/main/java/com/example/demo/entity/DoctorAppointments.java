package com.example.demo.entity;

import java.util.List;

public class DoctorAppointments {
	private int bookingid;
	//private Doctor doctor;
	private Patient patient;
	
	public DoctorAppointments(int bookingid, Patient patient) {
		super();
		this.bookingid = bookingid;
		this.patient = patient;
	}
	public DoctorAppointments() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "DoctorAppointments [bookingid=" + bookingid + ", patient=" + patient + "]";
	}
	


}
