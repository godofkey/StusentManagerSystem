package com.dreamworks.sms.resouce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {

	@Resource(name = "studentRealm")
    private StudentRealm studentRealm;

	@Resource(name = "teacherRealm")
	private TeacherRealm teacherRealm;
	
	@Resource(name = "educationalStaffRealm")
	private EducationalStaffRealm educationalStaffRealm;
	
	 @Override
	    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) {
	        
		   
	        // 判断getRealms()是否返回为空
	        assertRealmsConfigured();
	        // 强制转换回自定义的CustomizedToken
	        UserToken userToken = (UserToken) authenticationToken;
	        // 登录类型
	        String loginType = userToken.getLoginType();
	        
	        System.out.println("+++++++++++++---------------"+loginType);
	        if(loginType.equals("student")) {
	        
	        return doSingleRealmAuthentication(studentRealm, userToken);
	        } else if(loginType.equals("teacher")){
		        return doSingleRealmAuthentication(teacherRealm, userToken);
	        } else {
	        	return doSingleRealmAuthentication(educationalStaffRealm, userToken);
	        }
	       
	 }
}
