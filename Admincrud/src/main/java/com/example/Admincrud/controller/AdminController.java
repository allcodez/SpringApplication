package com.example.Admincrud.controller;

import com.example.Admincrud.model.Admin;
import com.example.Admincrud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/admin")
    public List<Admin> getAllAdmins(){
        return service.getAdmins();
    }

    @GetMapping("/admin/{Id}")
    public void findById(@PathVariable int id) {
        service.findbyid(id);
    }

    @PostMapping("/admin")
    public Admin createAdmin(@RequestBody Admin admin){
         return service.createAdmin(admin);
    }

    @PutMapping("/admin")
    public Admin updateAdmin(@RequestBody Admin admin){
        return service.updateadmin(admin);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteAdmin(@PathVariable int id){
        service.deleteAdminById(id);
    }
}
