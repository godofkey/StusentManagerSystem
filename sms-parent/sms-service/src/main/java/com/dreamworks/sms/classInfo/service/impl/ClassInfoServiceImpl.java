package com.dreamworks.sms.classInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.classInfo.dao.ClassInfoMapper;
import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.classInfo.service.ClassInfoService;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;

@Service
public class ClassInfoServiceImpl implements ClassInfoService{

	@Autowired
	private ClassInfoMapper classInfoMapper;
	
	@Override
	public List<ClassInfoDto> getClassInfo() {
		// TODO Auto-generated method stub
		List<ClassInfoPo> list1 = classInfoMapper.getClassInfo();
		ModelMapper modelMapper = new ModelMapper();
		List<ClassInfoDto> list2 = new ArrayList<ClassInfoDto>();
		for(ClassInfoPo classInfoPo : list1) {
			ClassInfoDto classInfoDto = modelMapper.map(classInfoPo,ClassInfoDto.class);
			list2.add(classInfoDto);
		}
		return list2;
	}

}
