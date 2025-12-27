package com.practice.spboot.manageemp.service;

import com.practice.spboot.manageemp.entities.Address;
import com.practice.spboot.manageemp.entities.Employee;
import com.practice.spboot.manageemp.entities.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMockServiceImpl implements EmployeeService {

    private static List<Employee> empList = new ArrayList<>();

    static {

        int empid = 0;
        int projectid = 0;
        int addressid = 0;

        Employee e1 = new Employee();
        e1.setEmpId(++empid);
        e1.setFirstName("Subhashsih");
        e1.setLastName("Ghosh");
        e1.setAge(38);
        e1.setSalary(10500.50);

        Address a1 = new Address();
        a1.setAddressId(++addressid);
        a1.setCity("Bangalore");
        a1.setCountry("India");

        Project p1 = new Project();
        p1.setProjectId(++projectid);
        p1.setProjectName("Google Cloud Upgrade");
        p1.setProjectDesc("To upgrade google cloud with Gen AI features");

        e1.setProject(p1);
        e1.setAddress(a1);

        p1.setEmployeeList(List.of(e1));

        empList.add(e1);
    }

    //Create
    public Employee addEmployee(Employee employeeToBeAdded) {
        empList.add(employeeToBeAdded);
        return employeeToBeAdded;
    }

    //Retrieve
    public List<Employee> getAllEmployees() {
        return empList;
    }

    //Retrieve
    public Employee getEmployeeById(int id) {
        return empList.stream().filter(e -> e.getEmpId()==id).findFirst().orElse(null);
    }

    //Update
    public Employee updateEmployee(Employee employeeToBeUpdated) {

        Employee employeeFromList = empList.stream().filter(emp -> emp.getEmpId() == employeeToBeUpdated.getEmpId()).findFirst().orElse(null);

        if (employeeFromList != null) {
            empList.remove(employeeFromList);
            empList.add(employeeToBeUpdated);
            return employeeToBeUpdated;
        } else {
            System.out.println("Error During Update : No Employee found with given details for empId : " + employeeToBeUpdated.getEmpId());
        }

        return null;
    }


    //Delete
    public void deleteEmployee(int id) {
        Employee employeeFromList = empList.stream().filter(emp -> emp.getEmpId() == id).findFirst().orElse(null);

        if (employeeFromList != null) {
            empList.remove(employeeFromList);
        } else {
            System.out.println("Error During Delete : No Employee found with given details for empId : " + id);
        }
    }
}
