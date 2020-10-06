package mybatis_spring_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.mapper.EmployeeMapper;
import mybatis_spring_study.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public int addEmployee(Employee emp) {
		return mapper.insertEmployee(emp);
	}

	@Override
	public int delEmployee(Employee emp) {
		return mapper.deleteEmployee(emp);
	}
	
}
