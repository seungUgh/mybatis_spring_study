package mybatis_spring_study.service;

import mybatis_spring_study.dto.Employee;

public interface EmployeeService {

	public int addEmployee(Employee emp);
	
	public int delEmployee(Employee emp);
	
}
