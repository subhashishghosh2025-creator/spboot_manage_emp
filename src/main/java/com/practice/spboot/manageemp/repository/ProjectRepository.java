package com.practice.spboot.manageemp.repository;

import com.practice.spboot.manageemp.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
