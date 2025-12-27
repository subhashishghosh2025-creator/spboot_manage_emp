package com.practice.spboot.manageemp.repository;

import com.practice.spboot.manageemp.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
