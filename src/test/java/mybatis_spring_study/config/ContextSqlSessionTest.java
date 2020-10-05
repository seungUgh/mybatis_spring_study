package mybatis_spring_study.config;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
public class ContextSqlSessionTest {

	protected static final Log log= LogFactory.getLog(ContextSqlSessionTest.class);
	
	@After
	public void tearDown() throws Exception {
		// 메소드 시작후에 한줄 띄워라 ~ 용도
		System.out.println();
	}
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	
	@Test
	public void testSqlSession() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		SqlSession session= sessionFactory.openSession();
		log.debug("session "+ session);
		Assert.assertNotNull(session);
	}

}
