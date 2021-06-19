package com.godoro.springcomplex.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.springcomplex.data.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
