package me.sifan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.sifan.domain.Student;
import me.sifan.service.StudentService;
import me.sifan.service.impl.StudentServiceImpl;

public class EditStudentPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		StudentService stuService = new StudentServiceImpl();
		
		Student stu = stuService.selectStudent(sid);
		
		request.setAttribute("stu", stu);
		
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
