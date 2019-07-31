package com.dreamworks.sms.course.po;

import java.io.Serializable;

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
public class CourseInfoPo implements Serializable{
	
	private Integer courseId;

    private String courseName;

    private Integer courseHour;
}
