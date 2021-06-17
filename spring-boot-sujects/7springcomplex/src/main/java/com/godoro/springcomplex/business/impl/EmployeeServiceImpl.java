package com.godoro.springcomplex.business.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.springcomplex.business.dto.EmployeeDetail;
import com.godoro.springcomplex.business.dto.EmployeeSummary;
import com.godoro.springcomplex.business.service.EmployeeService;
import com.godoro.springcomplex.data.entity.Department;
import com.godoro.springcomplex.data.entity.Employee;
import com.godoro.springcomplex.data.repository.DepartmentRepository;
import com.godoro.springcomplex.data.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void save(EmployeeDetail employeeDetail) {
		Employee employee = toEntitiy(employeeDetail);
		employeeRepository.save(employee);
		employeeDetail.setEmployeeId(employee.getEmployeeId());
	}

	@Override
	public void update(EmployeeDetail employeeDetail) {
		Employee employee = toEntitiy(employeeDetail);
		employeeRepository.save(employee);
	}

	@Override
	public void delete(long employeeId) {
		employeeRepository.deleteById(employeeId);

	}

	@Override
	public EmployeeDetail find(Long employeeId) {
		EmployeeDetail employeeDetail = null;
		if (employeeId != null) {

			Optional<Employee> employee = employeeRepository.findById(employeeId);
			if (employee.isPresent()) {
				employeeDetail = toDto(employee.get());
				return employeeDetail;
			}
		}
		if (employeeDetail == null) {
			employeeDetail = new EmployeeDetail();
			employeeDetail.setEmployeeName("");
		}
		return employeeDetail;
	}

	@Override
	public EmployeeSummary list() {
		EmployeeSummary employeeSummary = new EmployeeSummary();
		employeeSummary.setEmployeeDetailList(new ArrayList<>());
		for (Employee employee : employeeRepository.findAll()) {
			EmployeeDetail employeeDetail = toDto(employee);
			employeeSummary.getEmployeeDetailList().add(employeeDetail);
		}
		return employeeSummary;
	}

	@Override
	public EmployeeSummary listByDepartment(long departmentId) {
		EmployeeSummary employeeSummary = new EmployeeSummary();
		employeeSummary.setEmployeeDetailList(new ArrayList<>());
		Optional<Department> department = departmentRepository.findById(departmentId);
		if (department.isPresent()) {
			employeeSummary.setDepartmentId(department.get().getDepartmentId());
			employeeSummary.setDepartmentName(department.get().getDepartmentName());
		}

		for (Employee employee : employeeRepository.findByDepartment(departmentId)) {
			EmployeeDetail employeeDetail = toDto(employee);
			employeeSummary.getEmployeeDetailList().add(employeeDetail);
		}
		return employeeSummary;
	}

	@Override
	public int countByDepartment(long departmentId) {
		return employeeRepository.countByDepartment(departmentId);
	}

	private Employee toEntitiy(EmployeeDetail employeeDetail) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDetail.getEmployeeId());
		employee.setEmployeeName(employeeDetail.getEmployeeName());
		employee.setMounthSalary(employeeDetail.getMounthSalary());
		if (employeeDetail.getDepartmentId() != 0) {
			Optional<Department> department = departmentRepository.findById(employeeDetail.getDepartmentId());
			if (department.isPresent()) {
				employee.setDepartment(department.get());
			}
		}
		return employee;
	}

	private EmployeeDetail toDto(Employee employee) {
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setEmployeeId(employee.getEmployeeId());
		employeeDetail.setEmployeeName(employee.getEmployeeName());
		employeeDetail.setMounthSalary(employee.getMounthSalary());
		if (employee.getDepartment() != null) {
			employeeDetail.setDepartmentId(employee.getDepartment().getDepartmentId());
			employeeDetail.setDepartmentName(employee.getDepartment().getDepartmentName());
		}
		return employeeDetail;
	}

}
