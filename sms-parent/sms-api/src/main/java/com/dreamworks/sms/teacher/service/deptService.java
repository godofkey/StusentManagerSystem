package com.dreamworks.sms.teacher.service;

import java.util.List;

import com.dreamworks.sms.teacher.dto.Dept;


public interface deptService {

    public boolean add(Dept dept);
	
	public Dept get(Long id);
	
	public List<Dept> list();
}
