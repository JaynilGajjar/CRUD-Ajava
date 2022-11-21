package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.dao.EmpDao;

@WebServlet("/EmpController")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("insert"))
		{
			Emp e1=new Emp();
			e1.setFname(request.getParameter("fname"));
			e1.setLname(request.getParameter("lname"));
			e1.setEmail(request.getParameter("email"));
			e1.setMobile(request.getParameter("mobile"));
			e1.setAddress(request.getParameter("address"));
			EmpDao.insertEmp(e1);
			response.sendRedirect("show.jsp");
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			Emp e=EmpDao.getEmp(id);
			request.setAttribute("e", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("update"))
		{
			Emp e1=new Emp();
			e1.setId(Integer.parseInt(request.getParameter("id")));
			e1.setFname(request.getParameter("fname"));
			e1.setLname(request.getParameter("lname"));
			e1.setEmail(request.getParameter("email"));
			e1.setMobile(request.getParameter("mobile"));
			e1.setAddress(request.getParameter("address"));
			EmpDao.updateEmp(e1);
			response.sendRedirect("show.jsp");
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			EmpDao.deleteEmp(id);
			response.sendRedirect("show.jsp");
		}
	}

}
