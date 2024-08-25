package com.web.EmployeeApplication.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private String employeeCity;
    public Employee(){}
    public Employee(int employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }



    //realtions
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spouse_id")
    private Spouse spouse;

//    @OneToMany(mappedBy = "employee")
//    private List<Address> addresses;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_courses",
            joinColumns = @JoinColumn(name = "Employee_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id")
    )
    private List<Project> projects;

    public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployees().remove(this);
    }

    public void addProject(Project project){
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }



}
