package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.User_bo;
import com.dao.User_dao;


@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter pw = response.getWriter();
	    String email = request.getParameter("email");
	    String pass = request.getParameter("password");
	    HttpSession userSession = request.getSession();

	    try {
	        List<User_bo> li = User_dao.userData(email, pass);
	        if (!li.isEmpty()) {
	            String username = li.get(0).getUsername().toString();
	            String city = li.get(0).getCity().toString();
	            System.out.println(city + " " + username);

	            userSession.setAttribute("username", username);
	            userSession.setAttribute("email", email);
	            userSession.setAttribute("city", city);
	            userSession.setAttribute("pass", pass);
//	            pw.write(username);
	            String redirectUrl = request.getContextPath() + "/home.html";
	            response.sendRedirect(redirectUrl);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (!User_dao.userLogin(email, pass)) {
	        pw.println("<script> alert(\"Login failed\");</script>");

	        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        rd.include(request, response);
	    }
	}


	

}
