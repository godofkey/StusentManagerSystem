package com.dreamworks.sms.teacher.service;

import com.dreamworks.sms.teacher.dto.TeacherDto;
import com.dreamworks.sms.teacher.dto.TeacherQueryDto;

/**
 * @ClassName: TeacherLoginService
 * @Description: TODO
 * @Author: Jzxxxxx
 * @Date: Created in 2019/7/12 0012下午 4:07
 */
public interface TeacherLoginService {

    public TeacherDto findTeacherByTno(TeacherQueryDto teacherQueryDto);

}
