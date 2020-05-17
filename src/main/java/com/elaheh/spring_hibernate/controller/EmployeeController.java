package com.elaheh.spring_hibernate.controller;

import com.elaheh.spring_hibernate.exceptions.ItemNotFoundException;
import com.elaheh.spring_hibernate.model.Employee;
import com.elaheh.spring_hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/EmployeeController")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/InsertEmployee")
    public void insertEmployee(@RequestBody Employee employee){
        employeeService.create(employee);
    }

    @GetMapping("/GetByIdEmployee")
    public Employee employeeGetById(@RequestParam int id) throws ItemNotFoundException {
        return employeeService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/FindAllEmloyee")
    public List<Employee> employeeList(){
        return employeeService.findAll();
    }

    @PostMapping("/UpdateEmloyee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @DeleteMapping("/DeleteEmployee")
    public void deleteEmployee(@RequestParam int id){
        employeeService.deleteById(id);
    }
}
