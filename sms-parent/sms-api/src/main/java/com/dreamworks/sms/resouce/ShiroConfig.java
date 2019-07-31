package com.dreamworks.sms.resouce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String, String> filtermap = new HashMap<String, String>();
		
		//filtermap.put("/add","perms[add]");
		//filtermap.put("/aa/update","perms[update]");
		
		//filtermap.put("/**", "authc");
   		//filtermap.put("/aa/*", "authc");
  		//filtermap.put("/add","authc");
		//filtermap.put("/add","anon");
		//filtermap.put("/tologin","anon");
		//filtermap.put("/login","anon");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
		
		//shiroFilterFactoryBean.setUnauthorizedUrl("/auto");
		
		//shiroFilterFactoryBean.setLoginUrl("/test1");
		
		return shiroFilterFactoryBean;
	}
	
	
	@Bean("securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		//设置realm.
		defaultWebSecurityManager.setAuthenticator(modularRealmAuthenticator());
        List<Realm> realms = new ArrayList<>();
        //添加多个Realm
        realms.add(studentRealm());
        defaultWebSecurityManager.setRealms(realms);
 
        return defaultWebSecurityManager;
	}
	
	
	@Bean(name = "teacherRealm")
	public TeacherRealm teacherRealm() {
		TeacherRealm teacherRealm = new TeacherRealm();
		return teacherRealm;
	}
	
	
	@Bean(name = "studentRealm")
    public StudentRealm studentRealm(){
    	StudentRealm studentRealm = new StudentRealm();
        return studentRealm;
    }

	@Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

	
	
}
