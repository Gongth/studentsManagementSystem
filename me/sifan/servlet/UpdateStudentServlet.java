package me.sifan.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.sifan.domain.Student;
import me.sifan.service.StudentService;
import me.sifan.service.impl.StudentServiceImpl;

public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phonenum = request.getParameter("phonenum");
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hobby = request.getParameter("hobby");
		String info = request.getParameter("info");
		
		Student stu = new Student(sid, sname, gender, phonenum, birthday, hobby, info);
		
		StudentService stuService = new StudentServiceImpl();
		
		stuService.updateStudent(stu);
		
		request.getRequestDispatcher("SelectAllStudentsServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
