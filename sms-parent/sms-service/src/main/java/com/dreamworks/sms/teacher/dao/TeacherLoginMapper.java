package com.dreamworks.sms.teacher.dao;

import com.dreamworks.sms.teacher.dto.TeacherQueryDto;
import com.dreamworks.sms.teacher.po.TeacherPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: TeacherLoginMapper
 * @Description: TODO
 * @Author: Jzxxxxx
 * @Date: Created in 2019/7/12 0012下午 5:12
 */
@Mapper
public interface TeacherLoginMapper {

    public TeacherPo findTeacherByTno(TeacherQueryDto teacherQueryDto);

}
