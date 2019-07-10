package com.dreamworks.sms.student.dto;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.student.dto.StudentQueryDto.StudentQueryDtoBuilder;
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
public class StudentDto implements Serializable{
private String sno;
	
	private String spwd;
	
	private String sname;
	
	private String ssex;
	
	private Date sbirthday;
	
	private String saddress;
	
	private int tno;
	
	private int pno;
	
	private String sclass;
	
	private int studentId;
	
    private String ptel;
    
    private TeacherDto teacherDto;
}
