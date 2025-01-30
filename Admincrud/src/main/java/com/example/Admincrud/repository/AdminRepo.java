package com.example.Admincrud.repository;

import com.example.Admincrud.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
