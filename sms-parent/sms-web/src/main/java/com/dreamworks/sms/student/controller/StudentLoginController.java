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
import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.service.StudentLoginService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentLoginController {
   
	@Autowired
	private StudentLoginService studentLoginService;
	
	@RequestMapping(value = "/findStudentBySno", method = RequestMethod.POST)
    public JsonResult findStudentBySno(StudentQueryDto studentQueryDto) {
 
    	StudentDto studentDto = studentLoginService.findStudentBySno(studentQueryDto);
    	Subject subject = SecurityUtils.getSubject();  
		UsernamePasswordToken token = new UsernamePasswordToken(studentQueryDto.getSno(),studentQueryDto.getSpwd());
    	try {
			subject.login(token);
			StudentDto sDto = studentLoginService.findStudentBySno(studentQueryDto);
			return new JsonResult(ResultCode.SUCCESS, "登录成功", sDto);
		} catch (UnknownAccountException e) {
			// TODO: handle exception
			return new JsonResult(ResultCode.NOT_DATA, "用户名不存在");
		} catch (IncorrectCredentialsException e) {
			
			return new JsonResult(ResultCode.FAIL, "密码错误"); 
		}
    			
    }
}
