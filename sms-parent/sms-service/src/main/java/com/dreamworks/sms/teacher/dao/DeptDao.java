package com.dreamworks.sms.teacher.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.teacher.dto.Dept;



public interface DeptDao {

	public boolean addDept(Dept dept);
	
	public Dept findById(Long id);
	
	public List<Dept> findAll();
	
}
