package com.revanture.project1.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private String givenName;
    private String surname;
    private String roleId;
    private boolean active = false;
    
    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String email, String givenName, String surname, String roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.givenName = givenName;
        this.surname = surname;
        this.roleId = roleId;
    }
 public String getEmail(){
        return email;
 }
 public void setEmail(String email){
        this.email = email;
 }

 public String getGivenName(){
        return givenName;
 }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", givenName='" + givenName + '\'' +
                ", surname='" + surname + '\'' +
                ", roleID='" + roleId + '\'' +
                '}';
    }
}


