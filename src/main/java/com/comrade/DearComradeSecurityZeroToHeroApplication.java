package com.comrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class DearComradeSecurityZeroToHeroApplication {
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(DearComradeSecurityZeroToHeroApplication.class, args);
	}
}
