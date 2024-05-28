package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class getSessionCity
 */
@WebServlet("/getSessionCity")
public class getSessionCity extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String city = (String) session.getAttribute("city");
        response.setContentType("text/plain");
        System.out.println("\n"+city+"\n");
        response.getWriter().write(city);
    }

}
