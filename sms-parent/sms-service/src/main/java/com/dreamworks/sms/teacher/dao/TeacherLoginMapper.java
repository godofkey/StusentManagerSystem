package com.dreamworks.sms.teacher.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.po.StudentPo;
import com.dreamworks.sms.teacher.dto.TeacherQueryDto;
import com.dreamworks.sms.teacher.po.TeacherPo;

@Mapper
public interface TeacherLoginMapper {

	public TeacherPo findTeacherByTno(TeacherQueryDto teacherQueryDto);
}
