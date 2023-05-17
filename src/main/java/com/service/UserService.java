package com.service;

import java.util.List;

import com.dto.UserDTO;

public interface UserService {

	List<UserDTO> getUserList();

	UserDTO add(UserDTO userDto);

	UserDTO updateUser(UserDTO userDto);

	void deleteUser(int id);

	UserDTO getUserByEmail(String email);
	
	Boolean login(UserDTO userDTO);


}
