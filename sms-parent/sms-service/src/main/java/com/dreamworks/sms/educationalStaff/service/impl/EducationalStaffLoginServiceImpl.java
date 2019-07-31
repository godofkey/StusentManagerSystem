package com.dreamworks.sms.educationalStaff.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.educationalStaff.dao.EducationalStaffLoginMapper;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffQueryDto;
import com.dreamworks.sms.educationalStaff.po.EducationalStaffInfoPo;
import com.dreamworks.sms.educationalStaff.service.EducationalStaffLoginService;
import com.dreamworks.sms.student.dto.StudentInfoDto;

@Service
public class EducationalStaffLoginServiceImpl implements EducationalStaffLoginService{

	@Autowired
	private EducationalStaffLoginMapper educationalStaffLoginMapper;
	
	@Override
	public EducationalStaffInfoDto findStaffByEducationalStaffId(EducationalStaffQueryDto educationalStaffQueryDto) {
		// TODO Auto-generated method stub
		
		EducationalStaffInfoPo educationalStaffInfoPo = educationalStaffLoginMapper.findStaffByEducationalStaffId(educationalStaffQueryDto);
		
		if(educationalStaffInfoPo != null) {
		   ModelMapper modelMapper = new ModelMapper();
		   EducationalStaffInfoDto educationalStaffInfoDto = modelMapper.map(educationalStaffInfoPo,EducationalStaffInfoDto.class);
           return educationalStaffInfoDto;
		} else {
		  return null;
		}
	}

}
