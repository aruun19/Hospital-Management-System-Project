package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.DoctorDao;
import com.example.demo.dao.PatientDao;
import com.example.demo.dao.StaffDao;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.entity.Staff;
import com.example.demo.service.DoctorServiceImpl;
import com.example.demo.service.PatientServiceImpl;
import com.example.demo.service.StaffServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementSystemApplicationTests {
	@InjectMocks
	DoctorServiceImpl manager;
	@Mock
	DoctorDao dao;
	@InjectMocks
	StaffServiceImpl staffs;
	@Mock
	StaffDao da;
	@InjectMocks
	PatientServiceImpl managerr;
	@Mock
	PatientDao daoo;

	@Test
	void contextLoads() {
	}
	@Before(value = "")
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void getAllDoctorsTest() throws ParseException
	{
		Scanner sc=new Scanner(System.in);
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor doctOne = new Doctor(1001,"Govindaraju","Anacology","specialist","Maharashtra",9256432,"10 AM TO 5 PM","govind","govind@123");
		Doctor doctTwo = new Doctor(1002, "sureshkrishna", "biology","nutrionest","Ongole",986744330,"11 AM TO 4 PM","suresh","suresh@123");
		Doctor doctThree = new Doctor(1003, "Ramnathan", "Gynacology","Gynacologist","karnataka",97356310,"2 PM TO 10 PM","ram","ram@123");

		list.add(doctOne);
		list.add(doctTwo);
		list.add(doctThree);

		when(dao.findAll()).thenReturn(list);

		//test
		List<Doctor> doctList = dao.findAll();

		assertEquals(3, doctList.size());
		verify(dao, times(1)).findAll();
		
	}
	@Test
	public void getDoctorByIdTest() throws ParseException {
		int id1 = 1001;
		manager.findById(id1);
		verify(dao, times(1)).findById(id1);
	}
	@Test
	public void createDoctorTest() throws ParseException
	{
		{
			Scanner sc=new Scanner(System.in);
		Doctor doct = new Doctor(1004,"Govindarajulu","Anacology","specialist","Mumbai",92564322,"7 AM to 2 PM","govind","govind@123");

		manager.saveorUpdate(doct);

		verify(dao, times(1)).save(doct);

	}


	}
	@Test
	public void getAllStaffTest() throws ParseException
	{
		Scanner sc=new Scanner(System.in);
	     Date date = new Date();
		List<Staff> list = new ArrayList<Staff>();
		Staff staffOne = new Staff(1,"Nithin", "Pharmacist", 25000.0,5,date,"B.Pharm","9952491213","Chennai");
		Staff staffTwo = new Staff(4,"Siddharth", "Nurse", 20000.0,3,date,"DN","9955675345","Bangalore");
		Staff staffThree = new Staff(8,"Kumar", "Pharmacist", 20000.0,3,date,"B.Pharm","9079196224","Mumbai");

		list.add(staffOne);
		list.add(staffTwo);
		list.add(staffThree);

		when(da.findAll()).thenReturn(list);

		//test
		List<Staff> staffList = da.findAll();

		assertEquals(3, staffList.size());
		verify(da, times(1)).findAll();		

	}
	@Test
	public void getStaffByIdTest() throws ParseException {
		int id1 = 1;
		staffs.findById(id1);
		verify(da, times(1)).findById(id1);
	}
	@Test
	public void createStaffTest() throws ParseException
	{
		{
			Scanner sc=new Scanner(System.in);
						
						
			   Date date = new Date();
		Staff staff = new Staff(1,"Nithin", "Pharmacist", 25000.0,5,date,"B.Pharm","9952491213","Chennai");

		staffs.SaveorUpdate(staff);

		verify(da, times(1)).save(staff);

	}
  }
	@Test
	public void getAllPatientTest() throws ParseException
	{
		Scanner sc=new Scanner(System.in);
		List<Patient> list = new ArrayList<Patient>();
		Patient patientOne = new Patient(6,"Navya", "Jaundice","Female","9952491218","Anantapur","navya","navya@123","navyagori@gmail.com");
		Patient patientTwo = new Patient(4,"Aruna", "Leprosy","Female","9965789239","Pune","aruna","aruna@123","arunapoli@gmail.com");
		Patient patientThree = new Patient(3,"Shiva", "Dengue Fever","Male","9346879018","Kolkata","shiva","shiva@123","shivapoleti@gmail.com");
		list.add(patientOne);
		list.add(patientTwo);
		list.add(patientThree);

		when(daoo.findAll()).thenReturn(list);

		//test
		List<Patient> PatientList = daoo.findAll();

		assertEquals(3, PatientList.size());
		verify(daoo, times(1)).findAll();		

	}
	@Test
	public void getPatientByIdTest() throws ParseException {
		int id1 = 1;
		managerr.findById(id1);
		verify(daoo, times(1)).findById(id1);
	}
	@Test
	public void createPatientTest() throws ParseException
	{
		{
			Scanner sc=new Scanner(System.in);
		Patient patient = new Patient(6,"Navya", "Jaundice","Female","9952491219","Anantapur","navya","navya@123","navyagori@gmail.com");
		
        managerr.saveorUpdate(patient) ;
		verify(daoo, times(1)).save(patient);

	}

}


}


