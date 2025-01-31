package com.example.TeamProject.model;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(
        name = "admin-sequence",
        sequenceName = "admin_id_sequence",
        allocationSize = 1
)
public class Admin {

    @Id
    @SequenceGenerator(
            name = "admin-sequence",
            sequenceName = "admin_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin-sequence"
    )
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    private String address;

    public Admin() {
    }

    public Admin(String name, String phoneNumber, String email, String password, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
