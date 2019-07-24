package me.sifan.dao;

import java.util.List;

import me.sifan.domain.Student;

/**
 * 这是Student类的DAO(Data Access Object 数据访问对象)
 * 用来给业务层提供通用的增删改查的方法
 * 数据层与业务层解耦
 * 当修改数据层的具体实现时,不需要改动业务层的代码
 * 
 * @author Sifan
 * @date 2019-07-19
 * @version 1.0
 */

public interface StudentDao {
	
	int PAGE_SIZE = 5;
	
	//增
	void addStudent(Student stu);
	
	//删
	void deleteStudent(int sid);
	
	//改
	void updateStudent(Student stu);
	
	//查1
	Student selectStudent(int sid);
	
	//查2
	List<Student> selectStudent(String sname, String gender);
	
	List<Student> selectAllStudents();
	
	List<Student> selectStudentByPaging(int currentPage);
	
	int totalCount();
	
	
}
