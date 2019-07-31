package com.dreamworks.sms.resouce;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.dto.StudentQueryDto;
import com.dreamworks.sms.teacher.dto.TeacherInfoDto;
import com.dreamworks.sms.teacher.dto.TeacherQueryDto;
import com.dreamworks.sms.teacher.service.TeacherLoginService;

public class TeacherRealm extends AuthorizingRealm{

	@Autowired
	private TeacherLoginService teacherLoginService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UserToken token1 = (UserToken)token;
		TeacherQueryDto teacherQueryDto = new TeacherQueryDto();
		teacherQueryDto.setTeacherId(token1.getUsername());
  //		User user = new User();
  //		user.setUsername(token1.getUsername());
		TeacherInfoDto t = teacherLoginService.findTeacherByTeacherId(teacherQueryDto);

		if(t==null) {
			return null;	
		}	
		return new SimpleAuthenticationInfo(teacherQueryDto,t.getPassword(),getName());
		
	}

}
