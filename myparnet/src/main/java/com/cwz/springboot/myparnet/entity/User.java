package com.cwz.springboot.myparnet.entity;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "user")
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String beforeschool;
    private String kindergarten;
    private String primaryschool;
    private String middleschool;
    private String highschool;
    private String university;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBeforeschool() {
        return beforeschool;
    }

    public void setBeforeschool(String beforeschool) {
        this.beforeschool = beforeschool;
    }

    public String getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(String kindergarten) {
        this.kindergarten = kindergarten;
    }

    public String getPrimaryschool() {
        return primaryschool;
    }

    public void setPrimaryschool(String primaryschool) {
        this.primaryschool = primaryschool;
    }

    public String getMiddleschool() {
        return middleschool;
    }

    public void setMiddleschool(String middleschool) {
        this.middleschool = middleschool;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
