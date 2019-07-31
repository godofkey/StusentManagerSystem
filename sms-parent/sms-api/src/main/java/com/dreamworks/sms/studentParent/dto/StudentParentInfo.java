package com.dreamworks.sms.studentParent.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto.TeacherInfoDtoBuilder;

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
public class StudentParentInfo implements Serializable{
    
	private Integer parentId;

    private String parentName;

    private String teleNum;

    private String adress;

    private Integer studentId;

    private ClassInfoDto classInfoDto;
    
}