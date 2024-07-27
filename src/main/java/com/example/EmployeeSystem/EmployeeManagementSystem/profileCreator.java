package com.example.EmployeeSystem.EmployeeManagementSystem;

import jakarta.persistence.Column;

public class profileCreator {
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;

    private String address;
    private String department;
    private String gender;
    private String userRole;

    private String RegDate;

    private String jobTitle;

    public profileCreator(String id, String fullName, String email, String phoneNumber, String department, String gender,String address,String userole, String RegDate,String jobtitle) {
        this.id = id.toString();
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.gender = gender;
        this.userRole =userole;
        this.address=address;
        this.jobTitle = jobTitle;
        this.RegDate=RegDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
