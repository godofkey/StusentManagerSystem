package com.dreamworks.sms.student.service;

import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;

public interface StudentLoginService {

	public StudentDto findStudentBySno(StudentQueryDto studentQueryDto);
}
