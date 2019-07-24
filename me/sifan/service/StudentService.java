package me.sifan.service;

import java.util.List;

import me.sifan.domain.PageBean;
import me.sifan.domain.Student;

public interface StudentService {
	
	List<Student> selectAllStudents();
	
	void addStudent(Student stu);
	
	void deleteStudent(int sid);
	
	Student selectStudent(int sid);
	
	void updateStudent(Student stu);
	
	List<Student> selectStudent(String sname, String gender);
	
	PageBean<Student> selectStudentByPaging(int currentPage);
}
