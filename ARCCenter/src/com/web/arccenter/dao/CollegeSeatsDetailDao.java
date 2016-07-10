package com.web.arccenter.dao;

import com.web.arccenter.bean.CollegeSeatsDetailBean;
import com.web.arccenter.databaseconnection.MySqlHelper;

public class CollegeSeatsDetailDao 
{
	public int addCollegeSeatDetails(CollegeSeatsDetailBean collegeSeatsDetailBean) 
	{
		int sucess=0;

		System.out.println("Inside CollegeSeatsDetailDao class");

		int collegeid=collegeSeatsDetailBean.getCollegeid();
		String branch=collegeSeatsDetailBean.getBranch();
		int availableSeats=collegeSeatsDetailBean.getAvailableSeats();
		int criteria=collegeSeatsDetailBean.getCriteria();

		MySqlHelper helper=new MySqlHelper();

		sucess=helper.executeUpdate("insert into collegeseats values ('"+collegeid+"',+'"+branch+"','"+availableSeats+"','"+criteria+"')");

		System.out.println("Data inserted sucessfully in database");

		return sucess;
	}
}
