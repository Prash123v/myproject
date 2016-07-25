package com.web.arccenter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutAction extends HttpServlet
{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{		
		HttpSession session = request.getSession(false);

		if(session!=null)
		{
			session.invalidate();
			System.out.println(" Inside if condition session !=null");
			System.out.println("session destoyed");
		}
		else
		{
			System.out.println("Error in session destoye");
			response.sendRedirect("home.jsp");
		}
	}   
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request, response);
	}


}
