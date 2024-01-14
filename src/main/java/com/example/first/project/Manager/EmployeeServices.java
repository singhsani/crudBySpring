package com.example.first.project.Manager;

import com.example.first.project.Model.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee employee);
    void deleteById(Integer id);
}
