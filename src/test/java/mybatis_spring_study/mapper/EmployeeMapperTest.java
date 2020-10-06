package mybatis_spring_study.mapper;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {
	
	protected static final Log log= LogFactory.getLog(EmployeeMapperTest.class);
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private EmployeeMapper mapper;
	
	@Test
	public void test01InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee= new Employee(4444, "김사원", "과장", new Employee(4377), 4100000, new Department(1));
		int res= mapper.insertEmployee(employee);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee= new Employee(4444);
		int res= mapper.deleteEmployee(employee);
		Assert.assertEquals(1, res);
	}
}
