package com.web.arccenter.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.arccenter.bean.RegistrationBean;
import com.web.arccenter.dao.RegistrationDao;

@SuppressWarnings("serial")
public class RegistrationAction extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		try
		{
		

		registrationBean.setLoginName(request.getParameter("loginname"));
		registrationBean.setPassword(request.getParameter("password"));
		//registrationBean.setConfirmPassword(request.getParameter("confirmPassword"));
		registrationBean.setFirstName(request.getParameter("firstname"));
		registrationBean.setMiddleName(request.getParameter("middlename"));
		registrationBean.setLastName(request.getParameter("lastname"));

		registrationBean.setBirthDate(request.getParameter("birthdate"));
		registrationBean.setGender(request.getParameter("gender"));
		registrationBean.setAddress(request.getParameter("address"));
		registrationBean.setCity(request.getParameter("city"));
		registrationBean.setState(request.getParameter("state"));
		registrationBean.setCountry(request.getParameter("country"));
		registrationBean.setPincode(request.getParameter("pincode"));
		registrationBean.setPhone(request.getParameter("phone"));
		registrationBean.setEmail(request.getParameter("email"));
		registrationBean.setQualification(request.getParameter("qualification"));
		registrationBean.setPercentage(Integer.parseInt(request.getParameter("percentage")));
		registrationBean.setCollegeName(request.getParameter("college"));
		registrationBean.setAddQualification(request.getParameter("addqulification"));

		RegistrationDao registrationDao =new RegistrationDao();
		int sucess=registrationDao.registerUser(registrationBean);

		if(sucess>0)
		{
			System.out.println("Student Registration Sucessfull");
			response.sendRedirect("success.jsp");
		}
		else
		{
			System.out.println("Student Registration Failed");
			response.sendRedirect("registration.jsp");
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("registration.jsp");			
		}
	}
}
