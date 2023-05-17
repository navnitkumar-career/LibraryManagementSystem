package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AdminDTO;
import com.service.AdminService;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<AdminDTO> getAdminList() {
		return adminService.getAdminList();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public AdminDTO addAdmin(@RequestBody AdminDTO adminDTO) {
		return adminService.add(adminDTO);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		adminService.deleteAdminById(id);
	}
}
