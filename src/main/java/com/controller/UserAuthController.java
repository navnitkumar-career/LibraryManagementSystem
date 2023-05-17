package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserAuthController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
		Boolean flag=userService.login(userDTO);
		if(flag) {
			return ResponseEntity.status(HttpStatus.OK).body("Login Successfully.");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong EmailId or Password.");
		}
	}

}
