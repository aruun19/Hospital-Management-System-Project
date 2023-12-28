package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StaffDao;
import com.example.demo.entity.Staff;
@Service
public class StaffServiceImpl implements StaffService{
	@Autowired
	StaffDao dao;
	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Optional<Staff> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Override
	public void SaveorUpdate(Staff s) {
		// TODO Auto-generated method stub
		dao.save(s);
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	@Override
	public Staff findStaffBysName(String sName) {
		// TODO Auto-generated method stub
		return dao.findStaffBysName(sName);
	}
	
	

}

