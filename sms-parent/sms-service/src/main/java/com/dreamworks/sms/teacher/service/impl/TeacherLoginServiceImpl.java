package com.dreamworks.sms.teacher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.course.po.CourseInfoPo;
import com.dreamworks.sms.teacher.dao.TeacherLoginMapper;
import com.dreamworks.sms.teacher.dto.TeacherDto;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherQueryDto;
import com.dreamworks.sms.teacher.po.TeacherInfoPo;
import com.dreamworks.sms.teacher.po.TeacherPo;
import com.dreamworks.sms.teacher.service.TeacherLoginService;


@Service
public class TeacherLoginServiceImpl implements TeacherLoginService{


    @Autowired
    private TeacherLoginMapper teacherLoginMapper;

    @Override
    public TeacherInfoDto findTeacherByTeacherId(TeacherQueryDto teacherQueryDto){

        TeacherInfoPo teacherInfoPo = teacherLoginMapper.findTeacherByTeacherId(teacherQueryDto);
        if(teacherInfoPo!=null){
            ModelMapper modelMapper=new ModelMapper();
        	TeacherInfoDto teacherInfoDto = modelMapper.map(teacherInfoPo,TeacherInfoDto.class);
            List<ClassInfoPo> list = teacherInfoPo.getList();
            List<ClassInfoDto> list1 = new ArrayList<ClassInfoDto>();
            CourseInfoPo courseInfoPo = teacherInfoPo.getCourseInfoPo();
            if(list != null) {
            for(ClassInfoPo p : list) {
            	ClassInfoDto c = modelMapper.map(p,ClassInfoDto.class);	
            	list1.add(c);     
            }
            teacherInfoDto.setList(list1);
            }
            if(courseInfoPo != null) {
            CourseInfoDto courseInfoDto = modelMapper.map(courseInfoPo,CourseInfoDto.class);
            teacherInfoDto.setCourseInfoDto(courseInfoDto);
            }
            return teacherInfoDto;
        }else{
            return null;
        }
    }

}
