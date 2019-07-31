package com.dreamworks.sms.educationalStaff.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffQueryDto;
import com.dreamworks.sms.educationalStaff.service.EducationalStaffLoginService;
import com.dreamworks.sms.resouce.JsonResult;
import com.dreamworks.sms.resouce.ResultCode;
import com.dreamworks.sms.resouce.UserToken;

@RestController
@CrossOrigin
@RequestMapping("/educationalStaff")
public class EducationalStaffLoginController {

	@Autowired
	private EducationalStaffLoginService educationalStaffLoginService;
	
	@RequestMapping("/findStaffByEducationalStaffId")
	public JsonResult findStaffByEducationalStaffId(EducationalStaffQueryDto educationalStaffQueryDto) {
		EducationalStaffInfoDto educationalStaffInfoDto = educationalStaffLoginService.findStaffByEducationalStaffId(educationalStaffQueryDto);
		Subject subject = SecurityUtils.getSubject();  
    	UserToken token = new UserToken(educationalStaffQueryDto.getEducationalStaffId(),educationalStaffQueryDto.getPassword(),"educationalStaff");
    	try {
 			subject.login(token);
 			return new JsonResult(ResultCode.SUCCESS, "登录成功", educationalStaffInfoDto);
 		} catch (UnknownAccountException e) {
 			return new JsonResult(ResultCode.NOT_DATA, "用户名不存在");
 		} catch (IncorrectCredentialsException e) {
 			return new JsonResult(ResultCode.FAIL, "密码错误"); 
 		}		
	}
}
