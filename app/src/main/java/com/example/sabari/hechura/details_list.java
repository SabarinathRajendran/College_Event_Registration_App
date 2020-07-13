package com.example.sabari.hechura;

/**
 * Created by sabari on 2/14/2018.
 */

public class details_list {

    public String name, gender, college, dept, year, email, phone, tech, nontech, food;

    public details_list() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getNontech() {
        return nontech;
    }

    public void setNontech(String nontech) {
        this.nontech = nontech;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public details_list(String name, String gender, String college, String dept, String year, String email, String phone, String tech, String nontech, String food) {
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.dept = dept;
        this.year = year;
        this.email = email;
        this.phone = phone;
        this.tech = tech;
        this.nontech = nontech;
        this.food = food;
    }
}
