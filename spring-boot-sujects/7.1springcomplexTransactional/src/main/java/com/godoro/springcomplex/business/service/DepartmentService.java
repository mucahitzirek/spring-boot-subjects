package com.godoro.springcomplex.business.service;

import com.godoro.springcomplex.business.dto.DepartmentSummary;
import com.godoro.springcomplex.data.entity.Department;

public interface DepartmentService {

	public DepartmentSummary list();

	// transaction ve propagation deneme amacli yapildi...
	public long generateDepartment(String departmentName);

	public void generateEmployees(Department department);

}
