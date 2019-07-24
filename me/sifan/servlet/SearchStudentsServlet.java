package me.sifan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.sifan.domain.Student;
import me.sifan.service.StudentService;
import me.sifan.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class SearchStudentsServlet
 */
public class SearchStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		
		StudentService stuService = new StudentServiceImpl();
		List<Student> list = stuService.selectStudent(sname, gender);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
