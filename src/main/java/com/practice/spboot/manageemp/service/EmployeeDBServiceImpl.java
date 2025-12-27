package com.practice.spboot.manageemp.service;

import com.practice.spboot.manageemp.entities.Address;
import com.practice.spboot.manageemp.entities.Project;
import com.practice.spboot.manageemp.repository.AddressRepository;
import com.practice.spboot.manageemp.repository.EmployeeRepository;
import com.practice.spboot.manageemp.repository.ProjectRepository;
import com.practice.spboot.manageemp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDBServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProjectRepository projectRepository;

    //Create
    public Employee addEmployee(Employee employeeToBeAdded) {
        Project project = employeeToBeAdded.getProject();
        Address address = employeeToBeAdded.getAddress();

        Project projectFromDB = projectRepository.findByProjectName(employeeToBeAdded.getProject().getProjectName());
        if (projectFromDB != null) {
            employeeToBeAdded.setProject(projectFromDB);
        }

        return employeeRepository.save(employeeToBeAdded);
    }

    //Retrieve
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    //Retrieve
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //Update
    public Employee updateEmployee(Employee employeeToBeUpdated) {
        return employeeRepository.save(employeeToBeUpdated);
    }


    //Delete
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
