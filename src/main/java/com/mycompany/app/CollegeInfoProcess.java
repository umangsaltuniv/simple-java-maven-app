package com.as.samples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CollegeInfoProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sid=request.getParameter("sid");
		String course=request.getParameter("course");
		
		System.out.println("the sid is:"+sid);
		System.out.println("the course is:"+course);
		
		request.getSession().setAttribute("sid", sid);
		request.getSession().setAttribute("course", course);
		
		response.sendRedirect("jsp/Output.jsp");
		
	}

}
