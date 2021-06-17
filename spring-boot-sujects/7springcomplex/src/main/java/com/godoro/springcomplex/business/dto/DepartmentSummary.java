package com.godoro.springcomplex.business.dto;

import java.util.List;

public class DepartmentSummary {

	private List<DepartmentDetail> departmentDetailList;

	public List<DepartmentDetail> getDepartmentDetailList() {
		return departmentDetailList;
	}

	public void setDepartmentDetailList(List<DepartmentDetail> departmentDetailList) {
		this.departmentDetailList = departmentDetailList;
	}

}
