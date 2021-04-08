package com.example.demo.serviceImp;

import com.example.demo.dto.AdminFlowerDTO;

public interface AdminFlowerServiceImp {

	public boolean addAdmin(AdminFlowerDTO adminFlowerDTO);
	public boolean editAdminPassword(AdminFlowerDTO adminFlowerDTO);
	public boolean deleteAdmin(int idAdmin);
}
