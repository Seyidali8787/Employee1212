package com.example.EmployeeSystem.EmployeeManagementSystem;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeInterface employeeInterface;
    public EmployeeService(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    //    Add new employee
    public void addEmployee(Employee employee) {
        employeeInterface.save(employee);
    }

//   find all employees
    public List<Employee> getEmployeeDetails() {
        return employeeInterface.findAll();
    }


//  check if some one exist in the database
public  boolean isExist(Long id){
    Employee  person = employeeInterface.findById(id).orElse(null);
    if (person!=null){
        return true;
    }
    else
        return false;
}

//    check the user login
    public final boolean userCheck(Long id, String password) {
        boolean result = false;
        Employee  user = employeeInterface.findById(id).orElse(null);
        if (user != null) {
            Long ID=user.getId();
            if (user.getSecuritypass()==Integer.parseInt(password)){
                result=true;
            }
            else
                result= false;
        }
        return result;
    }


//    change your password
public void changepassword(long id, String oldpassword,String newpassword){
    Employee  user = employeeInterface.findById(id).orElse(null);
    if (user != null) {
        user.setSecuritypass(Integer.parseInt(newpassword));
        employeeInterface.save(user);
    }
}

//    check the user role admin or employee
    public boolean IsAdmin(Long userid) {
        boolean isadmin= false;
        if (userid != null) {
            Employee  user = employeeInterface.findById(userid).orElse(null);
            if (user.getUserRole().equals("Admin")||user.getUserRole().equals("admin")){
                isadmin= true;
            }
        }
        else
            isadmin= false;
        return isadmin;
    }


//    find the employee using id
    public Employee getEmployerById(Long id) {
        if (id != null)
            return employeeInterface.findById(id).orElse(null);
        else
            return null;
    }
//    delete employee
    public void deleteById(Long id) {
        employeeInterface.deleteById(id);
    }
}


