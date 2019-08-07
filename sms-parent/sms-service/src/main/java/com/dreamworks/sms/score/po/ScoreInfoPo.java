package com.dreamworks.sms.score.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.course.po.CourseInfoPo;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto.EducationalStaffInfoDtoBuilder;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.po.StudentInfoPo;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto;
import com.dreamworks.sms.teacher.po.TeacherInfoPo;

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
public class ScoreInfoPo implements Serializable{
	
    private Integer scoreId;

    private Integer studentId;

    private Integer teacherId;

    private Integer classId;

    private Integer scoreNum;
    
    private Integer courseId;
    
    private Integer rowNum;
    
    private Integer schoolRowNum;
    
	private Integer examinationName;

    private StudentInfoPo studentInfoPo;
    
    private CourseInfoPo courseInfoPo;
    
    private TeacherInfoPo teacherInfoPo;
    
    private ClassInfoPo classInfoPo;
    
}