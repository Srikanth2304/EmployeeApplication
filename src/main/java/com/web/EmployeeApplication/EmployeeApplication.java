package com.web.EmployeeApplication;

import com.web.EmployeeApplication.entity.Address;
import com.web.EmployeeApplication.entity.Employee;
import com.web.EmployeeApplication.entity.Project;
import com.web.EmployeeApplication.entity.Spouse;
import com.web.EmployeeApplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner createInistializer(EmployeeService employeeService){
		return (args) ->{
			Address address = new Address("line1","line2","zipCode1","city1","state1","country1");
			Spouse spouse = new Spouse(29,"mobile1","spouse_name");
			Project project = new Project("name1","clientName1");

			Employee employee = new Employee("Employee1","employeecity1");
			employee.addProject(project);
			employee.addAddress(address);
			employee.setSpouse(spouse);

			employeeService.createEmployee(employee);
			System.out.println("Getting an Employee");
			Employee employee1 = employeeService.getAnEmployee(1);
		};
	}


}
