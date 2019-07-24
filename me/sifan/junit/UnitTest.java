package me.sifan.junit;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import me.sifan.dao.DaoFactory;
import me.sifan.dao.StudentDao;
import me.sifan.dao.impl.StudentDaoJdbcImpl;
import me.sifan.domain.Student;

public class UnitTest {
	
	@Test
	public void Test01() {
		Properties properties = new Properties();
		InputStream is = StudentDaoJdbcImpl.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(is);
			DataSource datasource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("success"); 
	}
	
	@Test
	public void Test02() {
		Student stu = new Student();
		stu.setSname("小伟");
		stu.setGender("男");
		stu.setPhonenum("123123");
		stu.setBirthday(new Date());
		stu.setHobby("吃饭");
		stu.setInfo("睡觉");
		
		StudentDaoJdbcImpl studentDaoJdbcImpl = new StudentDaoJdbcImpl();
		studentDaoJdbcImpl.addStudent(stu);
		
		System.out.println(stu.getBirthday());
	}
	
	@Test
	public void test03() {
		for(int i = 0; i < 2000; i++) {
			StudentDao studentDao = DaoFactory.getInstance().getStudentDao();
			studentDao.selectAllStudents();
			System.out.println(studentDao);
		}
	}
	
	@Test
	public void test04() {
		StudentDao studentDao = DaoFactory.getInstance().getStudentDao();
//		studentDao.selectAllStudents();
		System.out.println(studentDao);
	}
	
	@Test
	public void test05() {
		String driverClass = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/school";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName(driverClass);
			Connection conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
