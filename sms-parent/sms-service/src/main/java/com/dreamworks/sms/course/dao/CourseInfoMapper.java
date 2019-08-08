package com.dreamworks.sms.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.course.po.CourseInfoPo;

@Mapper
public interface CourseInfoMapper {
  
	public List<CourseInfoPo> getCourseInfo();
}
