package com.dreamworks.sms.educationalStaff.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.educationalStaff.dto.EducationalStaffQueryDto;
import com.dreamworks.sms.educationalStaff.po.EducationalStaffInfoPo;

@Mapper
public interface EducationalStaffLoginMapper {

	public EducationalStaffInfoPo findStaffByEducationalStaffId(EducationalStaffQueryDto educationalStaffQueryDto);
}
