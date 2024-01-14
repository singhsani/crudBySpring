package com.example.first.project.Manager;

import com.example.first.project.Model.Employee;
import com.example.first.project.Repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeManager implements EmployeeServices {
    private EmployRepository employRepository;
    @Autowired
    public EmployeeManager(EmployRepository theEmployee){
        employRepository =theEmployee;
    }


    @Override
    public List<Employee> findAll() {
        return employRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
          employRepository.deleteById(id);
    }
}
