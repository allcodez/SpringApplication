package com.example.TeamProject.controller;

import com.example.TeamProject.model.Admin;
import com.example.TeamProject.model.Item;
import com.example.TeamProject.model.User;
import com.example.TeamProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return adminService.getAllItems();
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        return adminService.createItem(item);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return adminService.updateItem(id, item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        adminService.deleteItem(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }
}
