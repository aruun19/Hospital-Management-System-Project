package com.example.demo.entity;

public class PatientAppointments {
	private int bookingid;
	private Doctor doctor;
	
	public PatientAppointments() {
		
	}

	public PatientAppointments(int bookingid, Doctor doctor) {
		super();
		this.bookingid = bookingid;
		this.doctor = doctor;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "PatientAppointments [bookingid=" + bookingid + ", doctor=" + doctor + "]";
	}
	

}
