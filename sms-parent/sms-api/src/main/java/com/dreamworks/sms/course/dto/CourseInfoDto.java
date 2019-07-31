package com.dreamworks.sms.course.dto;

import java.io.Serializable;
import java.util.List;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.dto.ClassInfoDto.ClassInfoDtoBuilder;
import com.dreamworks.sms.student.dto.StudentInfoDto;

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
public class CourseInfoDto implements Serializable{
   
	private Integer courseId;

    private String courseName;

    private Integer courseHour;

}