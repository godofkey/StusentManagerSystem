package com.dreamworks.sms.student.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.student.dao.StudentLoginMapper;
import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.po.StudentInfoPo;
import com.dreamworks.sms.student.po.StudentPo;
import com.dreamworks.sms.student.service.StudentLoginService;
import com.dreamworks.sms.teacher.dto.TeacherDto;

@Service
public class StudentLoginServiceImpl implements StudentLoginService{

	@Autowired
	private StudentLoginMapper studentLoginDao;
	
	@Override
	public StudentInfoDto findStudentByStudentId(StudentQueryDto studentQueryDto) {
		// TODO Auto-generated method stub
		StudentInfoPo studentInfoPo = studentLoginDao.findStudentByStudentId(studentQueryDto);
		if(studentInfoPo != null) {
		ModelMapper modelMapper = new ModelMapper();
		StudentInfoDto sDto = modelMapper.map(studentInfoPo,StudentInfoDto.class);

		ClassInfoDto classInfoDto = modelMapper.map(studentInfoPo.getClassInfoPo(), ClassInfoDto.class);
		sDto.setClassInfoDto(classInfoDto);
		System.out.println("执行认证逻辑"+"=========++++++++++++"+sDto);

		return sDto;
		} else {
			return null;
		}
	}

}
