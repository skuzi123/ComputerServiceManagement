package com.example.BazyDanych2;

import com.example.BazyDanych2.Model.User;
import com.example.BazyDanych2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BazyDanych2Application {


	public static void main(String[] args) {
		SpringApplication.run(BazyDanych2Application.class, args);

	}

}
