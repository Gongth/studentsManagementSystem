package me.sifan.service.impl;

import java.util.List;

import me.sifan.dao.DaoFactory;
import me.sifan.dao.StudentDao;
import me.sifan.domain.PageBean;
import me.sifan.domain.Student;
import me.sifan.service.StudentService;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> selectAllStudents() {
		StudentDao studentdao = DaoFactory.getInstance().getStudentDao();
		return studentdao.selectAllStudents();
	}

	@Override
	public void addStudent(Student stu) {
		StudentDao studentdao = DaoFactory.getInstance().getStudentDao();
		studentdao.addStudent(stu);
	}

	@Override
	public void deleteStudent(int sid) {
		StudentDao stuDao = DaoFactory.getInstance().getStudentDao();
		stuDao.deleteStudent(sid);
	}
	
	@Override
	public Student selectStudent(int sid) {
		StudentDao stuDao = DaoFactory.getInstance().getStudentDao();
		return stuDao.selectStudent(sid);
	}

	@Override
	public void updateStudent(Student stu) {
		StudentDao stuDao = DaoFactory.getInstance().getStudentDao();
		stuDao.updateStudent(stu);
	}

	@Override
	public List<Student> selectStudent(String sname, String gender) {
		StudentDao stuDao = DaoFactory.getInstance().getStudentDao();
		return stuDao.selectStudent(sname, gender);
	}

	@Override
	public PageBean<Student> selectStudentByPaging(int currentPage) {
		StudentDao stuDao = DaoFactory.getInstance().getStudentDao();
		List<Student> list = stuDao.selectStudentByPaging(currentPage);
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		int pageSize = StudentDao.PAGE_SIZE;
		pageBean.setPageSize(pageSize);
		int total = stuDao.totalCount();
		pageBean.setTotalSize(total);
		int totalPage = total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1;
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
}
