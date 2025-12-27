package com.practice.spboot.manageemp.controller;

import com.practice.spboot.manageemp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageEmployeeController {

    @Autowired
    @Qualifier("employeeMockServiceImpl")
    private EmployeeService employeeService;

    @RequestMapping(path = "/testemp", method = RequestMethod.GET)
    public String testController() {
        return "ManageEmployeeController is working fine";
    }

}