package com.dreamworks.sms.resouce;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.dreamworks.sms.student.dto.StudentDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.service.StudentLoginService;


public class UserRealm extends AuthorizingRealm{

	@Autowired
	private StudentLoginService studentLoginService; 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
		// TODO Auto-generated method stub
//		System.out.println("执行授权逻辑");
//		
//		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//		
//		//simpleAuthorizationInfo.addStringPermission("user:add");
//		
//		Subject subject = SecurityUtils.getSubject();
//		
//		User user = (User)subject.getPrincipal();
//		System.out.println(user+"========================");
//		
//		
//		User user1 = findUserService.findUserByUserName(user);
//		
//		System.out.println(user1+"========================+++++++");
//		simpleAuthorizationInfo.addStringPermission(user1.getPers());
//		
//		
//		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("执行认证逻辑"+"======================");
		UsernamePasswordToken token1 = (UsernamePasswordToken)token;
		StudentQueryDto studentQueryDto = new StudentQueryDto();
		studentQueryDto.setSno(token1.getUsername());
//		User user = new User();
//		user.setUsername(token1.getUsername());
        StudentDto u = studentLoginService.findStudentBySno(studentQueryDto);
		if(u==null) {
			return null;	
		}	
		return new SimpleAuthenticationInfo(studentQueryDto,u.getSpwd(),getName());
		
	}

	

}
