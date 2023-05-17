package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public List<UserDTO> getUserList() {
		return userService.getUserList();
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public UserDTO addUser(@Valid @RequestBody UserDTO userDTO) {
		return userService.add(userDTO);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}

	@RequestMapping(path = "/{email}", method = RequestMethod.GET)
	public UserDTO getRecordByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmail(email);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		return userService.updateUser(userDTO);
	}

}
