package com.dreamworks.sms.teacher.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoDto.ScoreInfoDtoBuilder;
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
public class TeacherInfoDto implements Serializable{
	
    private Integer teacherId;

    private String teahcerName;

    private Date birth;

    private String adress;

    private Integer classId;

    private Short isHeadmaster;

    private Integer courseId;

    private String password;
  
    private List<ClassInfoDto> list;
    
    private CourseInfoDto courseInfoDto;
}