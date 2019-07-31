package com.dreamworks.sms.student.service;

import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;

public interface StudentLoginService {

	public StudentInfoDto findStudentByStudentId(StudentQueryDto studentQueryDto);
}
