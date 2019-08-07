package com.dreamworks.sms.course.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.course.po.CourseInfoPo;

@Mapper
public interface CourseInfoMapper {
  
	public CourseInfoPo getCourseInfoByStudentId();
}
