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
@Table(name="Patient")
public class Patient {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="pId")
		private int pId;
		
		@NotNull(message = "Patient name can't be empty")
	    @Size(max = 20,message = "Patient name can't be more than 20 characters")
	    @Size(min=4, message="Patient name must be more than 4 characters")
	    @Column(name="pName")
		private String pName;
		
		@NotBlank(message = "Disease name  can't be empty")
	    @Size(max = 20,message = "Disease name can't be more than 20 characters")
	    @Size(min=5, message="Disease name must be more than 5 characters")
	    @Column(name="Disease")
		private String DiseaseName;
		
		@NotNull(message = "ContactNumber name can't be null")
		@Size(max = 10,message = "ContactNumber name can't be more than 10 characters")
	    @Size(min=5, message="ContactNumber name must be more than 5 characters")
	    @Column(name="pContact")
		private String ContactNumber;
		
		@Column(name="Gender")
	    @NotNull(message = "Gender can not be empty")
		private String Gender;
		
		
		
		@Column(name="Address")
		@NotNull(message = "Address can not be empty")
		@Size(max = 35,message = "Address can't be more than 35 characters")
	    @Size(min=3, message="Address must be more than 5 characters")
		private String Address;
		@NotBlank(message = "Username cannot be blank")
		@Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
		@Column(name = "username")
		private String username;
		@NotBlank(message = "Patient password cannot be blank")
	    @Size(min = 6, message = "Patient password must be at least 6 characters")
	    @Column(name = "password")
		private String password;
		private String email;
	    public Patient()
	    {
	    	
	    }
		
		public Patient(int pId,
				@NotNull(message = "Patient name can't be empty") @Size(max = 20, message = "Patient name can't be more than 20 characters") @Size(min = 4, message = "Patient name must be more than 4 characters") String pName,
				@NotBlank(message = "Disease name  can't be empty") @Size(max = 20, message = "Disease name can't be more than 20 characters") @Size(min = 5, message = "Disease name must be more than 5 characters") String diseaseName,
				@NotNull(message = "ContactNumber name can't be null") @Size(max = 10, message = "ContactNumber name can't be more than 10 characters") @Size(min = 5, message = "ContactNumber name must be more than 5 characters") String contactNumber,
				@NotNull(message = "Gender can not be empty") String gender,
				@NotNull(message = "Address can not be empty") @Size(max = 35, message = "Address can't be more than 35 characters") @Size(min = 3, message = "Address must be more than 5 characters") String address,
				@NotBlank(message = "Username cannot be blank") @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters") String username,
				@NotBlank(message = "Patient password cannot be blank") @Size(min = 6, message = "Patient password must be at least 6 characters") String password,
				String email) {
			super();
			this.pId = pId;
			this.pName = pName;
			DiseaseName = diseaseName;
			ContactNumber = contactNumber;
			Gender = gender;
			Address = address;
			this.username = username;
			this.password = password;
			this.email = email;
		}

		public int getpId() {
			return pId;
		}

		public void setpId(int pId) {
			this.pId = pId;
		}

		public String getpName() {
			return pName;
		}

		public void setpName(String pName) {
			this.pName = pName;
		}

		public String getDiseaseName() {
			return DiseaseName;
		}

		public void setDiseaseName(String diseaseName) {
			DiseaseName = diseaseName;
		}

		public String getContactNumber() {
			return ContactNumber;
		}

		public void setContactNumber(String contactNumber) {
			ContactNumber = contactNumber;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			Gender = gender;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Patient [pId=" + pId + ", pName=" + pName + ", DiseaseName=" + DiseaseName + ", ContactNumber="
					+ ContactNumber + ", Gender=" + Gender + ", Address=" + Address + ", username=" + username
					+ ", password=" + password + ", email=" + email + "]";
		}

	    
	}	


