package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role  implements GrantedAuthority {
    private  Integer id;
    private  String  name;
    private  String  code;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    @Transient
    public String getAuthority() {
        return code;
    }
}
