package com.edu.nju.asi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String address;
    private String name;
    private int age;
    private String password;

    public User() {
    }

    public User(String address, String name, int age, String password) {
        this.address = address;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
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