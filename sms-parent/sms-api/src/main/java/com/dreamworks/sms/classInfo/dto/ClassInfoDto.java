package com.dreamworks.sms.classInfo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentDto.StudentDtoBuilder;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherDto;

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
public class ClassInfoDto implements Serializable{
    private Integer classId;

    private String className;

    private Integer classNum;

    private Integer grade;
    
    private List<StudentInfoDto> list;
}