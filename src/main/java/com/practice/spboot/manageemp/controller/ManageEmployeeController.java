package com.practice.spboot.manageemp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageEmployeeController {

    @RequestMapping(path = "/testemp", method = RequestMethod.GET)
    public String testController() {
        return "ManageEmployeeController is working fine";
    }
}
git s