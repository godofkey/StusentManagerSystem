package com.dreamworks.sms.resouce;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dreamworks.sms.educationalStaff.dto.EducationalStaffInfoDto;
import com.dreamworks.sms.educationalStaff.dto.EducationalStaffQueryDto;
import com.dreamworks.sms.educationalStaff.service.EducationalStaffLoginService;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.student.service.StudentLoginService;

public class EducationalStaffRealm extends AuthorizingRealm{

	@Autowired
	private EducationalStaffLoginService educationalStaffLoginService; 
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
		UserToken token1 = (UserToken)token;
		EducationalStaffQueryDto educationalStaffQueryDto = new EducationalStaffQueryDto();
		educationalStaffQueryDto.setEducationalStaffId(token1.getUsername());
  //		User user = new User();
  //		user.setUsername(token1.getUsername());
		EducationalStaffInfoDto u = educationalStaffLoginService.findStaffByEducationalStaffId(educationalStaffQueryDto);

		if(u==null) {
			return null;	
		}	
		return new SimpleAuthenticationInfo(educationalStaffQueryDto,u.getPassword(),getName());
		
	}

	
}
