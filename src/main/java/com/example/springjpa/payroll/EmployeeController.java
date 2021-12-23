package com.example.springjpa.payroll;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class EmployeeController
{


        @Autowired
        private  EmployeeRepository repository;

        @GetMapping("/employee")
        List<Employee> getAllEmployee()
        {
            return repository.findAll();
        }
        @PostMapping("/employee")
        Employee newEmployee(@RequestBody Employee newEmployee)
        {
            return repository.save(newEmployee);
        }
        @GetMapping("/employee")
//    Employee oneEmployee(@PathVariable Long id)
//    {
//      //  return repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
//    }
        @PutMapping("/employee/{id}")
        Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

            return repository.findById(id)
                    .map(employee -> {
                        employee.setName(newEmployee.getName());
                        employee.setRole(newEmployee.getRole());
                        return repository.save(employee);
                    })
                    .orElseGet(() -> {
                        newEmployee.setId(id);
                        return repository.save(newEmployee);
                    });
        }
        @DeleteMapping("/employee/{id}")
        void deleteEmployee(@PathVariable Long id) {
            repository.deleteById(id);
        }

    }


