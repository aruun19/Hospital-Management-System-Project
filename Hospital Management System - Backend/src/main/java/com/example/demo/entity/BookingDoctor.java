package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table
public class BookingDoctor {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookingId")
	private int bookingId;
	//@NotBlank(message = "patientId cannot be blank")
	private int patientId;
	//@NotBlank(message = "doctorId cannot be blank")
	private int doctorId;
	public BookingDoctor() {
		
	}
	public BookingDoctor(int bookingId, @NotBlank(message = "patientId cannot be blank") int patientId,
			@NotBlank(message = "doctorId cannot be blank") int doctorId) {
		super();
		this.bookingId = bookingId;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {
		return "BookingDoctor [bookingId=" + bookingId + ", patientId=" + patientId + ", doctorId=" + doctorId + "]";
	}
	
	

}
