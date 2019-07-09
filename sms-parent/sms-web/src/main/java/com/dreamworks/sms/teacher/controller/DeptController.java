package com.dreamworks.sms.teacher.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamworks.sms.teacher.dto.Dept;
import com.dreamworks.sms.teacher.po.Depttest;
import com.dreamworks.sms.teacher.service.deptService;


@RestController
public class DeptController {

	@Autowired
	private deptService deptService;
	
	@RequestMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept) {
		// TODO Auto-generated method stub
		return deptService.add(dept);
	}
	
	@RequestMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		// TODO Auto-generated method stub
		return deptService.get(id);
	}
	
	@RequestMapping(value = "/dept/list")
	public List<Dept> list() {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		Dept dept = new Dept((long) 1212234, "111111", "22222");
		Depttest depttest = modelMapper.map(dept,Depttest.class);
		return deptService.list();
	}
	
	
	
}
