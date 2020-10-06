package mybatis_spring_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;
import mybatis_spring_study.mapper.DepartmentMapper;
import mybatis_spring_study.mapper.EmployeeMapper;
import mybatis_spring_study.service.TransactionAopService;

//context-root에 context:component-scan base-package .service
@Service
public class TransactionAopServiceImpl implements TransactionAopService {
	@Autowired
	private DepartmentMapper deptMapper;
	
	@Autowired
	private EmployeeMapper empMapper;
	
	
	@Override
	public void trRegister(Department department, Employee employee) {
		//부서가 등록되고난 후 해당 부서에 사원을 추가 (해당부서가 존재해야만 사원추가되는 전제조건)
		deptMapper.insertDepartment(department);
		empMapper.insertEmployee(employee);
		
	}

	@Override
	public void trUnRegister(Department department, Employee employee) {
		int res= empMapper.deleteEmployee(employee);
		res+= deptMapper.deleteDepartment(department);
		
		if(res!= 2) throw new RuntimeException();
	}

}
