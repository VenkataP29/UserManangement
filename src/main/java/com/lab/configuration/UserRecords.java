package com.lab.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lab.entity.Role;
import com.lab.entity.User;
import com.lab.repository.UserRepository;

@Configuration
public class UserRecords {
	
	private UserRepository userRepo;
	
	public UserRecords(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
//	@Bean
//	public CommandLineRunner initializeDatabase() {
//		return args -> {
//            User user1 = new User("Tom@gmail.com", "tom123", Role.ADMIN);
//            User user2 = new User("john@yahoo.com", "john123", Role.ADMIN);
//            User user3 = new User("abc@gmail.com", "abc123", Role.USER);
//            User user4 = new User("kat@gmail.com", "kat123", Role.USER);
//             
//            userRepo.saveAll(List.of(user1, user2, user3, user4));
//             
//            System.out.println("Database initialized");
//        };
	}

