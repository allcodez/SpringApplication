package com.example.Admincrud.service;

import com.example.Admincrud.model.Admin;
import com.example.Admincrud.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo repo;


    public List<Admin> getAdmins() {
        return repo.findAll();
    }

    public Admin createAdmin(Admin admin) {
      return repo.save(admin);
    }

    public Admin updateadmin(Admin admin) {
        return repo.save(admin);
    }


    public void deleteAdminById(int id) {
        repo.deleteById(id);
    }


    public void findbyid(int id) {
         repo.findById(id);
    }
}
