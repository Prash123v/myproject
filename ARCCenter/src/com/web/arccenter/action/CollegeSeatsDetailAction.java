package com.web.arccenter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.arccenter.bean.CollegeDetailBean;
import com.web.arccenter.bean.CollegeSeatsDetailBean;
import com.web.arccenter.dao.CollegeDetailDao;
import com.web.arccenter.dao.CollegeSeatsDetailDao;

public class CollegeSeatsDetailAction extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{

		HttpSession session = request.getSession(true);
		try
		{
			CollegeSeatsDetailBean collegeSeatsDetailBean=new CollegeSeatsDetailBean();

			collegeSeatsDetailBean.setCollegeid(Integer.parseInt(request.getParameter("collegeid")));
			collegeSeatsDetailBean.setBranch(request.getParameter("branch"));
			collegeSeatsDetailBean.setAvailableSeats(Integer.parseInt( request.getParameter("availableSeats")));
			collegeSeatsDetailBean.setCriteria(Integer.parseInt( request.getParameter("criteria")));

			CollegeSeatsDetailDao collegeSeatsDetailDao =new CollegeSeatsDetailDao();

			int sucess = collegeSeatsDetailDao.addCollegeSeatDetails(collegeSeatsDetailBean);

			if(sucess>0)
			{
				System.out.println("College details added Sucessfuly");
				response.sendRedirect("success.jsp");
			}
			else
			{
				System.out.println("College details added Failed");
				response.sendRedirect("seatsentry.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("seatsentry.jsp");
		}
	}


}
