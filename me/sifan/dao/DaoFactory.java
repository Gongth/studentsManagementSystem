package me.sifan.dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;


public class DaoFactory {
	
	private static DaoFactory instance = new DaoFactory();
	private static String studentDaoClass;
	private StudentDao studentDao;
	
	static {
		Properties properties = new Properties();
		InputStream is = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
		try {
			properties.load(is);
			studentDaoClass = (String) properties.get("StudentDaoImplClass");
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private DaoFactory() {}
	
	public static DaoFactory getInstance() {
		return instance;
	}
	
	public StudentDao getStudentDao() {
		try {
			studentDao = (StudentDao)Class.forName(studentDaoClass).getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return studentDao;
	}
}
