package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="dId")
	private int dId;
	
	@NotNull(message = "Doctor name cannot be empty")
    @Size(max = 20,message = "Doctor name can't be more than 20 characters")
    @Size(min=2, message="Doctor name must be more than 5 characters")
    @Column(name="dname")
	private String dname;
	
	//@NotBlank(message = "Specilization can not be empty")
    @Size(max = 20,message = "Specilization can't be more than 20 characters")
    @Size(min=3, message="Specilization must be more than 5 characters")
    @Column(name="specilization")
	private String specilization;
	
	//@NotBlank(message = "Department can not be empty")
    //@Size(max = 20,message = "Department can't be more than 20 characters")
    //@Size(min=3, message="Department must be more than 5 characters")
    @Column(name="Department")
	private String Department;
	//@NotBlank(message = "city can not be empty")
    //@Size(max = 20,message = "city can't be more than 20 characters")
    //@Size(min=3, message="city must be more than 5 characters")
    @Column(name="city")
	private String city;
	//@NotBlank(message = "contactno can not be empty")
    //@Size(max = 10,message = "contactno can't be more than 10 numbers")
    //@Size(min=5, message="contactno must be more than 5 numbers")
    @Column(name="contactno")
	private long contactno;
	//@NotBlank(message = "availableTime can not be empty")
	@Column(name="availableTime")
	private String availableTime;
	//@NotBlank(message = "Username cannot be blank")
	//@Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
	@Column(name = "username")
	private String username;
	//@NotBlank(message = "Patient password cannot be blank")
    //@Size(min = 6, message = "Patient password must be at least 6 characters")
    @Column(name = "password")
	private String password;
	public Doctor(){
		
	}

	

	public Doctor(int dId,
			@NotNull(message = "Doctor name cannot be empty") @Size(max = 20, message = "Doctor name can't be more than 20 characters") @Size(min = 2, message = "Doctor name must be more than 5 characters") String dname,
			@NotBlank(message = "Specilization can not be empty") @Size(max = 20, message = "Specilization can't be more than 20 characters") @Size(min = 3, message = "Specilization must be more than 5 characters") String specilization,
			@NotBlank(message = "Department can not be empty") @Size(max = 20, message = "Department can't be more than 20 characters") @Size(min = 3, message = "Department must be more than 5 characters") String department,
			@NotBlank(message = "city can not be empty") @Size(max = 20, message = "city can't be more than 20 characters") @Size(min = 3, message = "city must be more than 5 characters") String city,
			@NotBlank(message = "contactno can not be empty") @Size(max = 10, message = "contactno can't be more than 10 numbers") @Size(min = 5, message = "contactno must be more than 5 numbers") long contactno,
			@NotBlank(message = "availableTime can not be empty") String availableTime,
			@NotBlank(message = "Username cannot be blank") @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") String username,
			@NotBlank(message = "Patient password cannot be blank") @Size(min = 6, message = "Patient password must be at least 6 characters") String password) {
		super();
		this.dId = dId;
		this.dname = dname;
		this.specilization = specilization;
		Department = department;
		this.city = city;
		this.contactno = contactno;
		this.availableTime = availableTime;
		this.username = username;
		this.password = password;
	}



	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSpecilization() {
		return specilization;
	}

	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", dname=" + dname + ", specilization=" + specilization + ", Department="
				+ Department + ", city=" + city + ", contactno=" + contactno + ", availableTime=" + availableTime
				+ ", username=" + username + ", password=" + password + "]";
	}

	
	
	
}

