package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserDTO;
import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<UserDTO> getUserList() {
		List<User> studList = userRepository.findAll();
		List<UserDTO> userList = studList.stream().map(t -> {
			UserDTO stud = new UserDTO();
			modelMapper.map(t, stud);
			return stud;
		}).collect(Collectors.toList());
		return userList;
	}

	@Override
	public UserDTO add(UserDTO userDto) {
		User user = new User();
		modelMapper.map(userDto, user);
		userRepository.save(user);
		return userDto;
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) {
		User user = userRepository.findByEmail(userDto.getEmail());
		if (userDto.getName() == null) {
			user.setPassword(userDto.getPassword());
		} else {
			modelMapper.map(userDto, user);
		}
		userRepository.save(user);
		return userDto;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public Boolean login(UserDTO UserDTO) {
		User stud = userRepository.findByEmail(UserDTO.getEmail());
		if (stud != null && stud.getPassword().contentEquals(UserDTO.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDTO getUserByEmail(String email) {

		User stud = userRepository.findByEmail(email);

		UserDTO User = new UserDTO();

		modelMapper.map(stud, User);
		return User;
	}

}
