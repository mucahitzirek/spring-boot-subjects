package com.godoro.springcomplex.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.godoro.springcomplex.data.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("select e from Employee e where e.department.departmentId = :departmentId")
	public List<Employee> findByDepartment(@Param("departmentId") long departmentId);

	@Query("select count(e.employeeId) from Employee e where e.department.departmentId = :departmentId")
	public int countByDepartment(long departmentId);

}
