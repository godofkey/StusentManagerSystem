package com.dreamworks.sms.teacher.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamworks.sms.teacher.dao.TeacherLoginMapper;
import com.dreamworks.sms.teacher.dto.TeacherDto;
import com.dreamworks.sms.teacher.dto.TeacherQueryDto;
import com.dreamworks.sms.teacher.po.TeacherPo;
import com.dreamworks.sms.teacher.service.TeacherLoginService;

/**
 * @ClassName: TeacherLoginServiceImpl
 * @Description: TODO
 * @Author: Jzxxxxx
 * @Date: Created in 2019/7/15 0015上午 9:08
 */
@Repository
public class TeacherLoginServiceImpl implements TeacherLoginService{


    @Autowired
    private TeacherLoginMapper teacherLoginMapper;

    @Override
    public TeacherDto findTeacherByTno(TeacherQueryDto teacherQueryDto){

        TeacherPo teacherPo = teacherLoginMapper.findTeacherByTno(teacherQueryDto);
        if(teacherPo!=null){
            ModelMapper modelMapper=new ModelMapper();
            TeacherDto tDto=modelMapper.map(teacherPo,TeacherDto.class);
            return tDto;
        }else{
            return null;
        }

    }

}
