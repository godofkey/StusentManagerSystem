package com.dreamworks.sms.educationalStaff.dto;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.course.dto.CourseInfoDto.CourseInfoDtoBuilder;

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
public class EducationalStaffInfoDto implements Serializable{
    
	private Integer educationalStafId;

    private String educationalStafName;

    private Date birth;

    private String adress;

    private String password;

}