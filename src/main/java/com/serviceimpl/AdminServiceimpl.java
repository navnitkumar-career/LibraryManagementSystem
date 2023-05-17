package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.AdminDTO;
import com.model.Admin;
import com.repository.AdminRepository;
import com.service.AdminService;

@Service
public class AdminServiceimpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Boolean login(AdminDTO adminDTO) {
		Admin admin = adminRepository.findByEmail(adminDTO.getEmail());
		if (admin != null && admin.getPassword().contentEquals(adminDTO.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<AdminDTO> getAdminList() {
		List<Admin> adminList = adminRepository.findAll();
		List<AdminDTO> admins = adminList.stream().map(t -> {
			AdminDTO admin = new AdminDTO();
			modelMapper.map(t, admin);
			return admin;
		}).collect(Collectors.toList());
		return admins;
	}

	@Override
	public AdminDTO add(AdminDTO adminDTO) {
		Admin admin = new Admin();
		modelMapper.map(adminDTO, admin);
		adminRepository.save(admin);
		return adminDTO;
	}

	@Override
	public void deleteAdminById(int id) {
		adminRepository.deleteById(id);
	}

}
