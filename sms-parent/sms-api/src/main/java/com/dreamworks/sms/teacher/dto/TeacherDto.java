package com.dreamworks.sms.teacher.dto;

import java.io.Serializable;
import java.util.Date;


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
public class TeacherDto implements Serializable{

	private int tno;
	
	private String tpwd;
	//身份识别
	private int ttag;

	private int radio;
}
