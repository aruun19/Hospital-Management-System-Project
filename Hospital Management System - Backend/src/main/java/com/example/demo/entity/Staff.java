package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="Staff")
public class Staff {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sId")
	private int sId;
	
	@NotNull(message = "Staff name can't be empty")
    @Size(max = 20,message = "Staff name can't be more than 20 characters")
    @Size(min=4, message="Staff name must be more than 4 characters")
    @Column(name="sName")
	private String sName;
	
	@NotBlank(message = "jobrole  can't be empty")
    @Size(max = 20,message = "jobrole can't be more than 20 characters")
    @Size(min=5, message="jobrole must be more than 5 characters")
    @Column(name="jobrole")
	private String jobrole;
	
	@NotNull(message = "Salary can't be null")
    @Max(value=100000, message ="Salary should not be greater than 100000" )
    @Min(value=10000, message="Salary must be greater than 1000")
    @Column(name="salary")
	private Double salary;
	
	@Column(name="exp")
    @NotNull(message = "exp can not be empty")
	private int exp;
	
	@Column(name="doj")
    @CreationTimestamp
	private Date doj;
	
	@Column(name="qualification")
    @NotNull(message = "qualification can't be null")
    @Size(max = 20,message = "qualification can't be more than 20 characters")
    @Size(min=2, message="qualification must be more than 2 characters")
	private String qualification;
	
	@Column(name="Contact")
	@NotNull(message = "Contact can not be empty")
	@Size(max = 12,message = "Contact can't be more than 12 numbers")
    @Size(min=5, message="Contact num must be of minimum 5 numbers")
	private String Contact;
	
	@Column(name="Address")
	@NotNull(message = "Address can not be empty")
	@Size(max = 35,message = "Address can't be more than 35 characters")
    @Size(min=5, message="Address must be more than 5 characters")
	private String Address;
    public Staff()
    {
    	
    }
	
	public Staff(int sId,
			@NotNull(message = "Staff name can't be empty") @Size(max = 20, message = "Staff name can't be more than 20 characters") @Size(min = 4, message = "Staff name must be more than 4 characters") String sName,
			@NotBlank(message = "jobrole  can't be empty") @Size(max = 20, message = "jobrole can't be more than 20 characters") @Size(min = 5, message = "jobrole must be more than 5 characters") String jobrole,
			@NotNull(message = "Salary can't be null") @Max(value = 100000, message = "Salary should not be greater than 100000") @Min(value = 10000, message = "Salary must be greater than 1000") Double salary,
			@NotNull(message = "exp can not be empty") int exp, Date doj,
			@NotNull(message = "qualification can't be null") @Size(max = 20, message = "qualification can't be more than 20 characters") @Size(min = 3, message = "qualification must be more than 3 characters") String qualification,
			@NotNull(message = "Contact can not be empty") @NotNull(message = "Contact can not be empty") @Size(max = 10, message = "Contact can't be more than 20 characters") @Size(min = 8, message = "Contact must be more than 3 characters") @NotNull(message = "Contact can not be empty") @Size(max = 15, message = "Contact can't be more than 15 numbers") @Size(min = 10, message = "Contact num must be of minimum 10 numbers") @NotNull(message = "Contact can not be empty") @Size(max = 8, message = "Contact can't be more than 8 numbers") @Size(min = 5, message = "Contact num must be of minimum 5 numbers") @NotNull(message = "Contact can not be empty") @Size(max = 12, message = "Contact can't be more than 12 numbers") @Size(min = 5, message = "Contact num must be of minimum 5 numbers") String contact,
			@NotNull(message = "Address can not be empty") @Size(max = 35, message = "Address can't be more than 35 characters") @Size(min = 5, message = "Address must be more than 5 characters") String address) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.jobrole = jobrole;
		this.salary = salary;
		this.exp = exp;
		this.doj = doj;
		this.qualification = qualification;
		this.Contact = contact;
		this.Address = address;
	}

	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		this.Contact = contact;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}

	@Override
	public String toString() {
		return "Staff [sId=" + sId + ", sName=" + sName + ", jobrole=" + jobrole + ", salary=" + salary + ", exp=" + exp
				+ ", doj=" + doj + ", qualification=" + qualification + ", Contact=" + Contact + ", Address=" + Address
				+ "]";
	}
	

    
}	