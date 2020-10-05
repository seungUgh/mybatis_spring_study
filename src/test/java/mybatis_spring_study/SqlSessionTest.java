package mybatis_spring_study;

import java.sql.SQLException;

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
public class SqlSessionTest {
	
	protected static final Log log= LogFactory.getLog(SqlSessionTest.class);
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void testOpenSession() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		SqlSession session= sqlSessionFactory.openSession();
		log.debug("session "+ session);
		Assert.assertNotNull(session);
	}

}
