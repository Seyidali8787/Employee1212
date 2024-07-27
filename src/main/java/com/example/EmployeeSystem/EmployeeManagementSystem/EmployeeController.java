package com.example.EmployeeSystem.EmployeeManagementSystem;
import org.apache.coyote.BadRequestException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//show loging page
    @GetMapping("/")
    public String showLoginForm() {
        return "login"; // This matches the Thymeleaf template name
    }

    @GetMapping("/login")
    public String backLoginForm() {
        return "login"; // This matches the Thymeleaf template name
    }

    //the page login is successful
    @RequestMapping("/login")
    public String login(@RequestParam("id") Long id, @RequestParam("password") String password, Model model) {
        //  checking logic here
        try {
            if (employeeService.userCheck(id, password)) {
                final  long getid=id;
                if (employeeService.IsAdmin(id)){
                    employees(model);
                    return   ("index");
                }
                else {
                    profileCreate(getid,model);
                    return ("employeeprofile");
                }
                // go to success page after login
            }
            else{
                model.addAttribute("loginError", true);
                // Return back to login page if authentication fails
                return ("login");
            }
        }

        catch (NumberFormatException e) {
            model.addAttribute("loginError", true);
            return ("login");
        }
        catch (Exception e) {
            model.addAttribute("loginError", true);
            return "login";
        }
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Employee());
        return "registration";
    }

    //registration
    @PostMapping("/save")
    public String  register(@ModelAttribute("user") Employee employee,Model model) {
        employeeService.addEmployee(employee);
        employees(model);
        return ("index");
    }

    @PostMapping("/newpass")
    public String newPass(@RequestParam("id") Long id, @RequestParam("password") String oldpassword,@RequestParam("newpassword") String newpassword,Model model,@ModelAttribute("user") Employee employee) {
        Employee user=employeeService.getEmployerById(id);
        if (id != null && user.getSecuritypass()==Integer.parseInt(oldpassword)){
            employeeService.changepassword(id,oldpassword,newpassword);
            return "succes";
        }
        else {
            model.addAttribute("passerror", true);
            profileCreate(id,model);
            return "employeeprofile";
        }
    }



@RequestMapping("/index")
public String getTest(){
        return "index";
}

    @RequestMapping("/SearchEmp")
    public  String SearchEmp (@Param("keyword") Long keyword, Model model) {
            List<profileCreator> Employeelist= getEmp(keyword);
            if (!(Employeelist==null)){
                model.addAttribute("employees",Employeelist);
            }
            return "adminprofile";
    }

    @RequestMapping("/employeeprofile")
    public  String profileCreate (Long id, Model model) {
            List<profileCreator> Employeelist = getEmp(id);
            if (!(Employeelist==null)) {
                model.addAttribute("Employeelist", Employeelist);
            }
            model.addAttribute("viewer", false);
            return "employeeprofile";
    }


    //for employee profile view
    public  List<profileCreator> getEmp(Long id) {
        Employee   entity=employeeService.getEmployerById(id);
        List<profileCreator>  Employeelist=new ArrayList<>();
        if (employeeService.isExist(id)){
            String idToString=id.toString();
            Employeelist.add(new profileCreator(idToString, entity.getFullName(), entity.getEmail(),  entity.getPhoneNumber(),entity.getDepartment(), entity.getGender(), entity.getAddress(), entity.getUserRole(),entity.getRegDate(),entity.getJobTitle()));
            return Employeelist;
        }
        else {
            return null;
        }
    }


    @GetMapping("/adminprofile")
    public  String employees (Model model) {
        List<Employee> employees= employeeService.getEmployeeDetails();
        model.addAttribute("employees", employees);
        return "adminprofile";
    }

    @RequestMapping("/delete/{id}")
    public  String deleteEmployee(@PathVariable Long id,Model model) {
        List<Employee> employees= employeeService.getEmployeeDetails();
        model.addAttribute("employees", employees);
        employeeService.deleteById(id);
        employees(model);
        return "index";
    }





    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
        Employee employee = employeeService.getEmployerById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }

//    view emp profile
    @GetMapping("/employeeprofile/{id}")
    public String viewEmployeeprofile(@PathVariable Long id,Model model){
        model.addAttribute("user", new Employee());
        profileCreate(id,model);
        model.addAttribute("viewer", true);
        return "employeeprofile";
    }
}
