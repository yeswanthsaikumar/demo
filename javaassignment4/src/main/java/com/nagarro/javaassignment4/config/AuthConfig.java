package com.nagarro.javaassignment4.config;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.javaassignment4.model.Tshirt;
import com.nagarro.javaassignment4.model.User;
import com.nagarro.javaassignment4.repository.UserRepository;
import com.nagarro.javaassignment4.repository.TshirtRepository;
import com.nagarro.javaassignment4.service.ThreadCSVRead;

@Configuration
public class AuthConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository loginRepository ,TshirtRepository tshirtRepository) {
		
		return args->{
			User yesh = new User("yesh@gmail.com","yesh");
			User yogi = new User("yogi@gmail.com","yogi");
			
			loginRepository.saveAll(List.of(yesh,yogi));
			
			
			final List<Tshirt> tshirts = new LinkedList<>();

			File dir = new File("C:/Users/yeswanthaddanki/git/yeswanth-sai-kumar-addanki/javaassignment1/csvdatafiles");
			File[] files = dir.listFiles();

			if (files.length == 0) {
				System.out.println("Directory is empty, Please try again");
			}

			
			Thread readcsvs = new ThreadCSVRead(files,tshirts);
			
			readcsvs.start();
			
			try {
				readcsvs.join();
			} catch (InterruptedException e) {
				System.out.println("unable join thread");
			}
			
			
			tshirtRepository.saveAll(tshirts);
		};
	}
	
}
