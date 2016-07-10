package com.web.arccenter.dao;

import com.web.arccenter.bean.CollegeDetailBean;
import com.web.arccenter.databaseconnection.MySqlHelper;

public class CollegeDetailDao
{	
	public int addCollegeDetails(CollegeDetailBean collegeDetailBean) 
	{
		int sucess=0;
 
		String collegename=collegeDetailBean.getCollegename();
		int establishedYear=collegeDetailBean.getEstablishedYear();
		String university=collegeDetailBean.getUniversity();
		String phone =collegeDetailBean.getPhone();
		String fax=collegeDetailBean.getFax();
		String email=collegeDetailBean.getEmail();
		String address=collegeDetailBean.getAddress();
		String city=collegeDetailBean.getCity();
		String state=collegeDetailBean.getState();
		String country=collegeDetailBean.getCountry();

		System.out.println("Inside CollegeDetailDao class");

		MySqlHelper helper=new MySqlHelper();

		sucess=helper.executeUpdate("insert into collegedetails (collegename,establishedYear,university,phone ,fax,email,address,city,state,country) values ('"+collegename+"','"+establishedYear+"','"+university+"','"+phone +"','"+fax+"','"+email+"','"+address+"','"+city+"','"+state+"','"+country+"')");

		System.out.println("Data inserted sucessfully in database");

		return sucess;
	}

}