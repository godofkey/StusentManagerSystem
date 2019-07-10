package com.dreamworks.sms.resouce;

import java.util.HashMap;
import java.util.Map;

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
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}
	
	
	
	@Bean("userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
	
	
}
