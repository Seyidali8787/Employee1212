package com.example.EmployeeSystem.EmployeeManagementSystem;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratorType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "EmployeeData")
public class Employee {
    public Employee(Long id,String fullName,String email,String phoneNumber,String address,String department,String gender,String userRole){};
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    @PrimaryKeyJoinColumn
    private long id;

    @Column(length = 50, nullable = false)
    private String fullName;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String phoneNumber;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String department;

    @Column(length = 6, nullable = false)
    private String gender;

    @Column(length = 6, nullable = false)
    private int securitypass=(int) (Math.floor((Math.random()+1)*999));
    @Column(length = 50, nullable = false)
    private String userRole;

    @Column(length = 50, nullable = false)
    private String RegDate=new Date().toLocaleString().substring(1,12);

    @Column(length = 50, nullable = false)
    private String jobTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getSecuritypass() {
        return securitypass;
    }

    public void setSecuritypass(int securitypas) {
            this.securitypass = securitypas;
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

//class EmployeeUser extends Employee{
//
//}