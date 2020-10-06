package mybatis_spring_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.mapper.DepartmentMapper;
import mybatis_spring_study.mapper.EmployeeMapper;
import mybatis_spring_study.service.TransactionAopService;

@Service
public class TransactionAopServiceImpl implements TransactionAopService {
	
	@Autowired
	private DepartmentMapper deptMapper;
	
	@Autowired
	private EmployeeMapper empMapper;
	
	
	@Override
	public int trRegister(Department department, Employee employee) {
		int res = deptMapper.insertDepartment(department);
		res += empMapper.insertEmployee(employee);
		if(res != 2) throw new RuntimeException();
		return res;
	}

	@Override
	public int trUnRegister(Department department, Employee employee) {
		int res  = empMapper.deleteEmployee(employee);
		res += deptMapper.deleteDepartment(department);
		if( res != 2) throw new RuntimeException();
		return res;
	}

}
