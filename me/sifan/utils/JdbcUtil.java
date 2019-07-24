package me.sifan.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import me.sifan.dao.impl.StudentDaoJdbcImpl;

public class JdbcUtil {
	
	private static DataSource dataSource;
	
	static {
		Properties properties = new Properties();
		InputStream is = StudentDaoJdbcImpl.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			properties.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
