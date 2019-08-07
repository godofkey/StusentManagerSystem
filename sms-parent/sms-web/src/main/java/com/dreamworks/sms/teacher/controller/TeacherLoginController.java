package com.dreamworks.sms.teacher.controller;


import org.apache.shiro.SecurityUtils;


import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dreamworks.sms.resouce.JsonResult;
import com.dreamworks.sms.resouce.ResultCode;
import com.dreamworks.sms.resouce.UserToken;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherDto;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherQueryDto;
import com.dreamworks.sms.teacher.service.TeacherLoginService;


@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherLoginController {

    @Autowired
    private TeacherLoginService teacherLoginService;
    @RequestMapping(value = "/findTeacherByTeacherId" , method = RequestMethod.POST)
    public JsonResult findTeacherByTno(TeacherQueryDto teacherQueryDto){        
        TeacherInfoDto teacherInfoDto=teacherLoginService.findTeacherByTeacherId((teacherQueryDto));
     	Subject subject = SecurityUtils.getSubject();  
     	UserToken token = new UserToken(teacherQueryDto.getTeacherId(),teacherQueryDto.getPassword(),"teacher");
     	try {
 			subject.login(token);
 			return new JsonResult(ResultCode.SUCCESS, "登录成功", teacherInfoDto);
 		} catch (UnknownAccountException e) {
 			return new JsonResult(ResultCode.NOT_DATA, "用户名不存在");
 		} catch (IncorrectCredentialsException e) {
 			return new JsonResult(ResultCode.FAIL, "密码错误"); 
 		}
     			
    }

}
