package com.dreamworks.sms.teacher.po;

import java.io.Serializable;

import com.dreamworks.sms.teacher.dto.TeacherDto;
import com.dreamworks.sms.teacher.dto.TeacherDto.TeacherDtoBuilder;

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
public class TeacherPo implements Serializable{

    private int tno;
	
	private String tpwd;
	
	private String tname;
	
	private int teacherId;
}
