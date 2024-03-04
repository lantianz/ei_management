package indi.ltz.ei_management01.service;

import indi.ltz.ei_management01.domain.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmins();
    Admin getAdminByUsername(String username);
    Admin getAdminById(String id);
    Admin addAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(String id);
}