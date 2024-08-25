package com.web.EmployeeApplication.controller;

import com.web.EmployeeApplication.entity.Address;
import com.web.EmployeeApplication.entity.Employee;
import com.web.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody

public class EmployeeController {
    @Autowired
    EmployeeService employeeservice;

//    @RequestMapping("/employees")
    @GetMapping("/employees")
    public List<Employee> FindAlEmployess(){
        return employeeservice.GetAllEmployees();
    }

//    @RequestMapping("/employees/{Id}")
    @GetMapping("/employees/{Id}")
    public Employee FindAnEmployee(@PathVariable int Id){
        return employeeservice.getAnEmployee(Id);
    }

//    @RequestMapping(value = "/employees" ,method = RequestMethod.POST)
    @PostMapping("/employees")
    public ResponseEntity<String> AddAnEmployee(@RequestBody Employee employee){
         employeeservice.createEmployee(employee);
        return new ResponseEntity<> ("Created",HttpStatus.OK);
    }

//    @RequestMapping(value = "/employees/{Id}",method = RequestMethod.PUT)
    @PutMapping("/employees/{Id}")
    public ResponseEntity<String> updateEmployeeDetails(@PathVariable int Id , @RequestBody Employee employee){
        employeeservice.updateEmployee(employee);
        return new ResponseEntity<> ("Updated",HttpStatus.OK);
    }

//    @RequestMapping(value = "/employees/{Id}" , method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{Id}")
    public ResponseEntity<String> deleteEmployeeDetails(@PathVariable int Id){
        employeeservice.deleteEmployee(Id);
        return new ResponseEntity<> ("Deleted",HttpStatus.OK);
//        return employeeservice.GetAllEmployees();
    }
    @PostMapping("/employees/batch")
    public ResponseEntity<String> addMultipleEmployees(@RequestBody List<Employee> employees){
        for(Employee employee : employees){
            employeeservice.createEmployee(employee);
        }
        return new ResponseEntity<>("added multiple employees" , HttpStatus.OK);
    }

//    @PostMapping("/address")
//    public ResponseEntity<String> createAddress(@RequestBody Address address){
//        return new ResponseEntity<>(address);
//    }
}
