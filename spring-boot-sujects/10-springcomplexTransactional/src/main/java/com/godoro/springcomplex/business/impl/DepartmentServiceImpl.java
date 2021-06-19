package com.godoro.springcomplex.business.impl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.godoro.springcomplex.business.dto.DepartmentDetail;
import com.godoro.springcomplex.business.dto.DepartmentSummary;
import com.godoro.springcomplex.business.service.DepartmentService;
import com.godoro.springcomplex.data.entity.Department;
import com.godoro.springcomplex.data.entity.Employee;
import com.godoro.springcomplex.data.repository.DepartmentRepository;
import com.godoro.springcomplex.data.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public DepartmentSummary list() {

		DepartmentSummary departmentSummary = new DepartmentSummary();
		departmentSummary.setDepartmentDetailList(new ArrayList<>());
		for (Department department : departmentRepository.findAll()) {
			DepartmentDetail departmentDetail = toDto(department);
			departmentSummary.getDepartmentDetailList().add(departmentDetail);
		}
		return departmentSummary;
	}

	// varligi aktarim nesnesine donusturur toDto
	private DepartmentDetail toDto(Department department) {

		DepartmentDetail departmentDetail = new DepartmentDetail();
		departmentDetail.setDepartmentId(department.getDepartmentId());
		departmentDetail.setDepartmentName(department.getDepartmentName());

		return departmentDetail;
	}

	@Override
	@Transactional
	public long generateDepartment(String departmentName) {

		// Bir bolume
		Department department = new Department();
		department.setDepartmentName(departmentName);
		departmentRepository.save(department);

		generateEmployees(department);

		return department.getDepartmentId();
	}

	// prpagation -> transactionun yayilip yayilmayacagina karar vermemizi saglar..
	// Required -> Beni dogrudan cagiriyorsan bir transaction baslat ama bir seyin
	// icinde cagiriyorsan transactionumu baslatma var olani kullan
	// requirednew ise benim icin ayri bir transaction olusturur (benden kasit bu
	// metheod)
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void generateEmployees(Department department) {

		// 3 tane calisan kaydediliyor..
		// 3u olursa olur, olmazsa olmaz
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Sekreter");
		employee1.setMounthSalary(3900);
		employee1.setDepartment(department);
		employeeRepository.save(employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Sofor");
		employee2.setMounthSalary(3900);
		employee2.setDepartment(department);
		employeeRepository.save(employee2);

		/*
		 * Normaklde 3. employee veri tabanina eklenmez ama ilk ikisi eklenir.. Bu
		 * 3'ununde eklenmesi gereken durumunda yarim yapilan bir kayit islemi sayilir
		 * 
		 * @Transactional ile bu engellenir ve bir hata olursa hic bir kayit
		 * gerceklesmez..
		 */
		if (true) {
			throw new RuntimeException("Kaza");
		}

		@SuppressWarnings("unused")
		Employee employee3 = new Employee();
		employee3.setEmployeeName("Cayci");
		employee3.setMounthSalary(3900);
		employee3.setDepartment(department);
		employeeRepository.save(employee3);

	}

}
