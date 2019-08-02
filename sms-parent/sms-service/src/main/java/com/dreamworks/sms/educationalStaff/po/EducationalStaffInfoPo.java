package com.dreamworks.sms.educationalStaff.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
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
public class EducationalStaffInfoPo implements Serializable{
	
	private Integer educationalStaffId;

    private String educationalStafName;

    private Date birth;

    private String adress;

    private String password;
}
