package com.dreamworks.sms.course.dto;

import java.io.Serializable;

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
public class CourseInfoQueryDto implements Serializable{

	private int studentId;
	
}
