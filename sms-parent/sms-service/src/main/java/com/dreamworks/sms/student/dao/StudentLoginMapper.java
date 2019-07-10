package com.dreamworks.sms.student.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.po.StudentPo;

@Mapper
public interface StudentLoginMapper {

	public StudentPo findStudentBySno(StudentQueryDto studentQueryDto);
}
