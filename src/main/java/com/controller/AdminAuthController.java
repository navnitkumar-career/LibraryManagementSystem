package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AdminDTO;
import com.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAuthController {

	@Autowired
	AdminService adminService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AdminDTO adminDTO) {
		Boolean flag = adminService.login(adminDTO);
		if (flag) {
			return ResponseEntity.status(HttpStatus.OK).body("Login Successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong EmailId or Password.");
		}
	}
}
