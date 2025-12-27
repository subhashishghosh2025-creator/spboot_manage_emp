package com.practice.spboot.manageemp.controller;

import com.practice.spboot.manageemp.entities.Employee;
import com.practice.spboot.manageemp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ManageEmployeeController {

    @Autowired
    @Qualifier("employeeMockServiceImpl")
    private EmployeeService employeeService;

    @RequestMapping(path = "/testemp", method = RequestMethod.GET)
    public String testController() {
        return "ManageEmployeeController is working fine";
    }

    @RequestMapping(path = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        System.out.println("Call Received in getAllEmployees");

        List<Employee> employees = employeeService.getAllEmployees();

        try {
        if (CollectionUtils.isEmpty(employees)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(employees);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(path = "/employees/employee/{empId}", method = RequestMethod.GET)
    private ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int id) {

        Employee emp = employeeService.getEmployeeById(id);

        try {
            if (emp == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.ok(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}