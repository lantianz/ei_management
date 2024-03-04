package indi.ltz.ei_management01.controller;

import indi.ltz.ei_management01.domain.entity.Admin;
import indi.ltz.ei_management01.domain.entityVo.AdminVo;
import indi.ltz.ei_management01.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping( "/admin-home")
    public String getAdminHome() {
        return "admin-home";
    }

    // 获取所有管理员信息
    @GetMapping("/adminInfo")
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        List<AdminVo> adminVos = admins.stream()
                .map(AdminVo::new)
                .toList();
        model.addAttribute("admins", adminVos);
        return "nav/adminInfo";
    }

    // 登录
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(String username, String password) {
        Map<String, String> response = new HashMap<>();
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            response.put("status", "success");
            response.put("message", "登录成功");
        } else {
            response.put("status", "error");
            response.put("message", "用户名或密码错误");
        }
        return ResponseEntity.ok(response);
    }


    // 根据id获取管理员信息
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable String id) {
        // 根据id获取管理员信息
        return adminService.getAdminById(id);
    }

    // 添加管理员信息
    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin) {
        // 添加管理员信息
        return adminService.addAdmin(admin);
    }

    // 更新管理员信息
    @PutMapping
    public Admin updateAdmin(@RequestBody Admin admin) {
        // 更新管理员信息
        return adminService.updateAdmin(admin);
    }

    // 根据id删除管理员信息
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable String id) {
        // 根据id删除管理员信息
        adminService.deleteAdmin(id);
    }
}