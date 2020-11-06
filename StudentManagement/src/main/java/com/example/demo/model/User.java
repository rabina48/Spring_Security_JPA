package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
public class User {
    private Integer id;
    private String fullName;
    private String address;
    private String department;
    private String email;
    private String position;
    private String password;
    private List<Role> roles;

    @JoinTable(name = "user_role",
                      joinColumns = @JoinColumn(name = "user_id"),
                      inverseJoinColumns = @JoinColumn(name = "role_id"))

    @ManyToMany
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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


}
