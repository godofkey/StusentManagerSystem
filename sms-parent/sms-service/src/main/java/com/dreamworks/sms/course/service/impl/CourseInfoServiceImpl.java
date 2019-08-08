package com.dreamworks.sms.course.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.course.dao.CourseInfoMapper;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.course.po.CourseInfoPo;
import com.dreamworks.sms.course.service.CourseInfoService;

@Service
public class CourseInfoServiceImpl implements CourseInfoService{

	@Autowired
	private CourseInfoMapper courseInfoMapper;
	@Override
	public List<CourseInfoDto> getCourseInfo() {
		// TODO Auto-generated method stub
		List<CourseInfoPo> list1 = courseInfoMapper.getCourseInfo();
		ModelMapper modelMapper = new ModelMapper();
		List<CourseInfoDto> list2 = new ArrayList<CourseInfoDto>();
		for(CourseInfoPo courseInfoPo : list1) {
			CourseInfoDto courseInfoDto = modelMapper.map(courseInfoPo,CourseInfoDto.class);
			list2.add(courseInfoDto);
		}
		return list2;
	}

}
