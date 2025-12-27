package com.practice.spboot.manageemp.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_desc")
    private String projectDesc;

    @OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
    private List<Employee> employeeList;

    public void setEmployeeList(List<Employee> empList) {
        if (CollectionUtils.isEmpty(employeeList)) {
            employeeList = new ArrayList<>();
        }
        employeeList.addAll(empList);
    }
}
