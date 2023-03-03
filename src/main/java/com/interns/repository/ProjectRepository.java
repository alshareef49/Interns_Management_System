package com.interns.repository;

import com.interns.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer> {
}
