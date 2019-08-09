package com.dreamworks.sms.score.dto;

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
public class ScoreInfoQueryDto implements Serializable{

	private int studentId;
	
	private int examinationName;
	
	private String classId;
	
	private String courseId;
}
