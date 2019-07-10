package com.dreamworks.sms.student.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.student.dao.StudentLoginMapper;
import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.po.StudentPo;
import com.dreamworks.sms.student.service.StudentLoginService;
import com.dreamworks.sms.teacher.po.Depttest;

@Service
public class StudentLoginServiceImpl implements StudentLoginService{

	@Autowired
	private StudentLoginMapper studentLoginDao;
	
	@Override
	public StudentDto findStudentBySno(StudentQueryDto studentQueryDto) {
		// TODO Auto-generated method stub
		StudentPo studentPo = studentLoginDao.findStudentBySno(studentQueryDto);
		if(studentPo != null) {
		ModelMapper modelMapper = new ModelMapper();
		StudentDto sDto = modelMapper.map(studentPo,StudentDto.class);
		return sDto;
		} else {
			return null;
		}
	}

}
