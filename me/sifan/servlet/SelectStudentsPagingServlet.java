package me.sifan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.sifan.domain.PageBean;
import me.sifan.domain.Student;
import me.sifan.service.StudentService;
import me.sifan.service.impl.StudentServiceImpl;

public class SelectStudentsPagingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		StudentService stuService = new StudentServiceImpl();
		
		PageBean<Student> pageBean = stuService.selectStudentByPaging(currentPage);
		
		request.setAttribute("pageBean", pageBean);

		request.getRequestDispatcher("paging.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
