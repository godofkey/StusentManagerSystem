package com.dreamworks.sms.score.dto;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto.EducationalStaffInfoDtoBuilder;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto;

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
public class ScoreInfoDto implements Serializable{
	
    private Integer scoreId;

    private Integer studentId;

    private Integer teacherId;

    private Integer classId;

    private Integer scoreNum;

    private StudentInfoDto studentInfoDto;
    
    private TeacherInfoDto teacherInfoDto;
    
    private ClassInfoDto classInfoDto;
    
    private CourseInfoDto courseInfoDto;
}