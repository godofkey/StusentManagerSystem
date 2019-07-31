package com.dreamworks.sms.educationalStaff.service;

import org.springframework.stereotype.Service;

import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffQueryDto;


public interface EducationalStaffLoginService {
	public EducationalStaffInfoDto findStaffByEducationalStaffId(EducationalStaffQueryDto educationalStaffQueryDto);

}
