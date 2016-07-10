package com.web.arccenter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.arccenter.bean.CollegeDetailBean;
import com.web.arccenter.bean.LoginBean;
import com.web.arccenter.dao.CollegeDetailDao;
import com.web.arccenter.dao.LoginDao;

public class CollegeDetailAction extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{

		try{
			HttpSession session = request.getSession(true);

			CollegeDetailBean collegeDetailBean=new CollegeDetailBean();

			collegeDetailBean.setCollegename(request.getParameter("collegename"));
			collegeDetailBean.setEstablishedYear(Integer.parseInt(request.getParameter("establishedYear")));
			collegeDetailBean.setUniversity(request.getParameter("university"));
			collegeDetailBean.setPhone(request.getParameter("phone"));
			collegeDetailBean.setFax(request.getParameter("fax"));
			collegeDetailBean.setEmail(request.getParameter("email"));
			collegeDetailBean.setAddress(request.getParameter("address"));
			collegeDetailBean.setCity(request.getParameter("city"));
			collegeDetailBean.setState(request.getParameter("state"));
			collegeDetailBean.setCountry(request.getParameter("country"));

			CollegeDetailDao collegeDetailDao =new CollegeDetailDao();

			int sucess=collegeDetailDao.addCollegeDetails(collegeDetailBean);

			if(sucess>0)
			{
				System.out.println("College details added Sucessfuly");
				response.sendRedirect("success.jsp");
			}
			else
			{
				System.out.println("College details added Failed");
				response.sendRedirect("collegeentery.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("collegeentery.jsp");
		}
	}
}
