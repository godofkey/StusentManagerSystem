package com.dreamworks.sms.teacher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.teacher.dao.DeptDao;
import com.dreamworks.sms.teacher.dto.Dept;
import com.dreamworks.sms.teacher.service.deptService;



@Service
public class deptServiceImpl implements deptService{

	@Autowired
	private DeptDao deptDao; 
	
	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
				}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}
