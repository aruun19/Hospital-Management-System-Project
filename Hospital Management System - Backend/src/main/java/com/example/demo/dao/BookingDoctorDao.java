package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookingDoctor;


@Repository
public interface BookingDoctorDao extends JpaRepository<BookingDoctor, Integer>{
	@Query(value = "SELECT * FROM Booking_Doctor bd WHERE bd.patient_Id  = ?1",nativeQuery = true  )
	public BookingDoctor viewAppointments(Integer pid);
	
	@Query(value =
			  "SELECT * FROM Booking_Doctor bd WHERE bd.doctor_id = ?1",nativeQuery = true) 
			  public List<BookingDoctor> viewdoctorAppointments(int did);
	@Query(value =
			  "SELECT * FROM Booking_Doctor bd WHERE bd.patient_id = ?1",nativeQuery = true) 
			  public List<BookingDoctor> viewpatientAppointments(int pid);

}
