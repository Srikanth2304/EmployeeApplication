package com.web.EmployeeApplication.service;

import com.web.EmployeeApplication.entity.Address;
import com.web.EmployeeApplication.entity.Employee;
import com.web.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class EmployeeService {
//    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
//            new Employee( "Srikanth" , "chennai"),
//            new Employee("vamsi","hyderabad")
//    ));

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> GetAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getAnEmployee(int Id){
//        return employeeList.stream().filter(employee -> (employee.getEmployeeId() == Id)).findFirst().get();
        return employeeRepository.findById(Id).orElseThrow(() ->new RuntimeException());
    }

    public void createEmployee(Employee employee){

        List<Address> addresses = new ArrayList<>();

        for(Address address : employee.getAddresses()){
            addresses.add(new Address(address.getLine1() , address.getLine2() , address.getZipCode() , address.getCity(),address.getState() ,address.getCountry(), employee));
        }
        employee.setAddresses(addresses);

        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
//        List<Employee>dummy = new ArrayList<>();
//        for(Employee e : employeeList){
//            if(e.getEmployeeId() == employee.getEmployeeId()){
//                e.setEmployeeCity(employee.getEmployeeCity());
//                e.setEmployeeName((employee.getEmployeeName()));
//            }
////            dummy.add(e);
//        }
//        this.employeeList = dummy;
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int Id){
//        for(Employee e : employeeList){
//            if(e.getEmployeeId() == Id){
//                employeeList.remove(e);
//            }
//        }
        employeeRepository.delete(employeeRepository.getById(Id));
    }

//    public void createAddress(Address address){
//        employeeRepository.save(address);
//    }


//    public void deleteEmployee(int Id){
//        List<Employee>dummy = new ArrayList<>();
//        for(Employee e : employeeList){
//            if(e.getEmployeeId() == Id){
//                continue;
//            }
//            dummy.add(e);
//        }
//        this.employeeList = dummy;
//    }

}