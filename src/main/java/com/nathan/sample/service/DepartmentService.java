package com.nathan.sample.service;

import sample.nathan.com.v1.Department;
import sample.nathan.com.v1.DepartmentList;

public interface DepartmentService {

	DepartmentList getDepartments(String uri);

	Department getDepartment(int id);

	Department save(Department department);

}
