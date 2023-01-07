package com.example.BazyDanych2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BazyDanych2Application {
//    @Autowired
//    private UserService userService;
//
//	@GetMapping("/getAllUsers")
//	public List<User> findAllUsers(){
//		return userService.getAllUsers();
//	}



	public static void main(String[] args) {
		SpringApplication.run(BazyDanych2Application.class, args);

	}

}
