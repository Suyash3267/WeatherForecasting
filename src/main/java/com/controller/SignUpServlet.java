package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.User_bo;
import com.dao.User_dao;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		String pass=request.getParameter("password");

		User_bo obj=new User_bo(username, email, city, pass);
		PrintWriter pw=response.getWriter();
		
		if(User_dao.adduser(obj)) {
			System.out.println("Sign up done ");
			pw.print("<script>alert(\"Successfully signed up please Log in \")</script>");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	rd.include(request, response);
		}
		else {
			pw.print("<script>alert(\"Invalid inputs please enter details again \")</script>");
			RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
	}
	}
}
