package com.example.first.project.RestController;

import com.example.first.project.DTO.CustomException;
import com.example.first.project.Manager.EmployeeManager;
import com.example.first.project.Manager.EmployeeServices;
import com.example.first.project.Model.Employee;
import com.example.first.project.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/test")
public class Controller {
    List<Employee> list;
    private EmployeeManager employeeManager;
    @Autowired
    public Controller(EmployeeManager employeeServices){
        employeeManager=employeeServices;
    }
    @PostConstruct
    public void loadData(){
        list=new ArrayList<>();
        list.add(new Employee("Raj","patel","rp@gmail.com"));
        list.add(new Employee("Rakesh","Yadav","ry@gmail.com"));
        list.add(new Employee("mohan","Singh","ms@gmail.com"));
        list.add(new Employee("Ram","Singh","rs@gmail.com"));
    }
    //http://localhost:8080/test/hello
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello Roy !";
    }
    @GetMapping("/listOfData/{studentId}")
    public Employee getData(@PathVariable int studentId){
        if(studentId >= list.size() || studentId<0)
            throw new CustomException("Student id not found " + studentId);
        return list.get(studentId);
    }

    @GetMapping("/employeeDetail")
    public List<Employee> getAll(){
        return employeeManager.findAll();
    }
    @GetMapping("/employeeDetail/{employeeId}")
    public Employee getDataOfSingleEmployee(@PathVariable Integer employeeId){
        Employee employee=employeeManager.findById(employeeId);
        if(Objects.isNull(employee))
            throw new RuntimeException("Employee Not found -" + employeeId);
        return employee;
    }
    @PostMapping("/employeeDetail")
    public Employee saveEmployeeDetail(@RequestBody Employee employee){
        employee.setId(employee.getId());
        Employee employee1=employeeManager.save(employee);
        return employee1;
    }
    @PutMapping("/employees")
    public Employee updateEmployeeDetail(@RequestBody Employee employee){
        Employee employee1=employeeManager.save(employee);
        return employee1;
    }
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployeeDetail(@PathVariable Integer employeeId){
        employeeManager.deleteById(employeeId);
        return "delete employee --"+employeeId;
    }
}
