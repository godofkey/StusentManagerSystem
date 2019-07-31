package com.dreamworks.sms.educationalStaff.dto;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto.EducationalStaffInfoDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class EducationalStaffQueryDto implements Serializable{

	private String educationalStaffId;
	
	private String password;
	
	private String loginType;
}
