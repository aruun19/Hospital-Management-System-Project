package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Staff;
@Repository
public interface StaffDao extends JpaRepository<Staff, Integer>  
{
	Staff findStaffBysName(String sName);
}

