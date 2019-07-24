package me.sifan.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import me.sifan.dao.DaoException;
import me.sifan.dao.StudentDao;
import me.sifan.domain.Student;
import me.sifan.utils.JdbcUtil;

public class StudentDaoJdbcImpl implements StudentDao{
	
	
	@Override
	public void addStudent(Student stu) {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		try {
			queryRunner.update("insert into students values(null,?,?,?,?,?,?)", stu.getSname(),stu.getGender(), stu.getPhonenum(), stu.getBirthday(), stu.getHobby(), stu.getInfo());
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		}
	}

	@Override
	public void deleteStudent(int sid) {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		try {
			queryRunner.update("delete from students where sid = ?", sid);
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		}
	}

	@Override
	public void updateStudent(Student stu) {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		try {
			queryRunner.update("update students set sname = ?, gender = ?, phonenum = ?, birthday = ?, hobby = ?, info = ? where sid = ?", stu.getSname(),stu.getGender(), stu.getPhonenum(), stu.getBirthday(), stu.getHobby(), stu.getInfo(), stu.getSid());
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		}
	}

	@Override
	public Student selectStudent(int sid) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		Student stu = null;
		try {
			stu = runner.query("select * from students where sid = ?", new BeanHandler<Student>(Student.class), sid);
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
		return stu;
	}

	@Override
	public List<Student> selectStudent(String sname, String gender) {
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from students where 1=1 ";
		List<String> list = new ArrayList<String>();
		if(sname != null && sname.length() != 0) {
			sql = sql + "and sname like ? ";
			list.add("%" + sname + "%");
		}
		if(gender != null && gender.length() != 0) {
			sql = sql + "and gender = ? ";
			list.add(gender);
		}
		
		try {
			return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Student> selectAllStudents(){
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		List<Student> list = null;
		try {
			list = queryRunner.query("select * from students", new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		}
		return list;
	}
	
	@Override
	public List<Student> selectStudentByPaging(int currentPage){
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		List<Student> list = null;
		String sql = "select * from students limit ? offset ?";
		try {
			list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage-1)*PAGE_SIZE);
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		}
		
		return list;
	}
	
	@Override
	public int totalCount() {
		QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
		
		Long totalCount;
		try {
			totalCount = (Long)queryRunner.query("select count(*) from students", new ScalarHandler());
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		}
		
		return totalCount.intValue();
	}
	
}
