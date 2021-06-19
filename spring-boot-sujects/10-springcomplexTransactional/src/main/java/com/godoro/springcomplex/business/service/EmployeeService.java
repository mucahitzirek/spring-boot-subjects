package com.godoro.springcomplex.business.service;

import com.godoro.springcomplex.business.dto.EmployeeDetail;
import com.godoro.springcomplex.business.dto.EmployeeSummary;

public interface EmployeeService {

	public void save(EmployeeDetail employeeDetail);

	public void update(EmployeeDetail detail);

	public void delete(long employeeId);

	public EmployeeDetail find(Long employeeId);

	public EmployeeSummary list();

	public EmployeeSummary listByDepartment(long departmentId);

	public int countByDepartment(long departmentId);
}
