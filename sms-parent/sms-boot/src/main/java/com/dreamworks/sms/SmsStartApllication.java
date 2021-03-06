package com.dreamworks.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.dreamworks.sms.*.dao")
@ComponentScan("com.dreamworks.sms")
public class SmsStartApllication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SpringApplication.run(SmsStartApllication.class, args);
	}
}
