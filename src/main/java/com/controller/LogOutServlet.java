package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 // Get the session associated with this request
	    HttpSession session = request.getSession(false);
	    
	    if (session != null) {
	      // Invalidate the session to remove any session data
	      session.invalidate();
	    }
	  
	    // Redirect the user to the login page
	  response.sendRedirect(request.getContextPath() + "/index.jsp");

		
	}

}
