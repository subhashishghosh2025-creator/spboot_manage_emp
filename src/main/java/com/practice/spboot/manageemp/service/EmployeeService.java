package com.practice.spboot.manageemp.service;

import com.practice.spboot.manageemp.entities.Employee;

import java.util.List;

public interface EmployeeService {

    //Create
    Employee addEmployee(Employee employeeToBeAdded);

    //Retrieve
    public List<Employee> getAllEmployees();

    //Retrieve
    Employee getEmployeeById(int id);

    //Update
    Employee updateEmployee(Employee employeeToBeUpdated);

    //Delete
    void deleteEmployee(int id);
}
