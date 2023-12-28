package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.entity.Staff;

public interface StaffService 
{
	public List<Staff> findAll();
	public Optional<Staff>findById(int id);
	public void SaveorUpdate(Staff s);
	public void deleteById(int id);
	Staff findStaffBysName(String sName);
	
}

