package com.dreamworks.sms.teacher.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.course.po.CourseInfoPo;
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
public class TeacherInfoPo implements Serializable{
	
	private Integer teacherId;

    private String teahcerName;

    private Date birth;

    private String adress;

    private Integer classId;

    private Short isHeadmaster;

    private Integer courseId;

    private String password;
  
    private List<ClassInfoPo> list;
    
    private CourseInfoPo courseInfoPo;
    
}
