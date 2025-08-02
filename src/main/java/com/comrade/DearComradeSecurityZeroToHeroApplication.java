package com.comrade;

import com.comrade.entity.ComradeUserEntity;
import com.comrade.repository.ComradeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DearComradeSecurityZeroToHeroApplication {

	@Autowired
	private ComradeUserRepository comradeUserRepository;
	public static void main(String[] args) {
		SpringApplication.run(DearComradeSecurityZeroToHeroApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return wer->{
			ComradeUserEntity comradeUserEntity = ComradeUserEntity.builder().username("dasari").password("shiva").enabled(true).build();
			comradeUserRepository.save(comradeUserEntity);
		};
	}
}
