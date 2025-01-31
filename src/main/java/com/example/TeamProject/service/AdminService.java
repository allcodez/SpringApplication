package com.example.TeamProject.service;

import com.example.TeamProject.model.Admin;
import com.example.TeamProject.model.Item;
import com.example.TeamProject.model.User;
import com.example.TeamProject.repository.AdminRepo;
import com.example.TeamProject.repository.ItemRepository;
import com.example.TeamProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElseThrow();
        existingItem.setName(item.getName());
        return itemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
