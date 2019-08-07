package com.dreamworks.sms.student.controller;


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
import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.service.StudentLoginService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentLoginController {
   
	@Autowired
	private StudentLoginService studentLoginService;
	
	@RequestMapping(value = "/findStudentByStudentId", method = RequestMethod.POST)
    public JsonResult findStudentByStudentId(StudentQueryDto studentQueryDto) {
        StudentInfoDto studentInfoDto = studentLoginService.findStudentByStudentId(studentQueryDto);
    	Subject subject = SecurityUtils.getSubject();  
    	UserToken token = new UserToken(studentQueryDto.getStudentId(),studentQueryDto.getPassword(),"student");
    	try {
			subject.login(token);
			StudentInfoDto studentInfoDto1 = studentLoginService.findStudentByStudentId(studentQueryDto);
			return new JsonResult(ResultCode.SUCCESS, "登录成功", studentInfoDto1);
		} catch (UnknownAccountException e) {
			// TODO: handle exception
			return new JsonResult(ResultCode.NOT_DATA, "用户名不存在");
		} catch (IncorrectCredentialsException e) {
			return new JsonResult(ResultCode.FAIL, "密码错误"); 
		}
    			
    }
}
