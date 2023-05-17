package com.service;

import java.util.List;

import com.dto.AdminDTO;

public interface AdminService {

	Boolean login(AdminDTO adminDTO);

	List<AdminDTO> getAdminList();

	AdminDTO add(AdminDTO adminDTO);

//	AdminDTO update(AdminDTO adminDTO);
	void deleteAdminById(int id);
}
