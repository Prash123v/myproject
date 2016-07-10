package com.web.arccenter.dao;

import java.util.Date;

import com.web.arccenter.bean.RegistrationBean;
import com.web.arccenter.databaseconnection.MySqlHelper;

public class RegistrationDao 
{
	public int registerUser(RegistrationBean registrationBean)
	{
		int sucess=0;
		String loginName=registrationBean.getLoginName() ;
		String password=registrationBean.getPassword();
		String firstName=registrationBean.getFirstName(); 
		String middleName=registrationBean.getMiddleName() ; 	
		String lastName=registrationBean.getLastName();	
		String birthDate=registrationBean.getBirthDate();  	
		String gender=registrationBean.getGender();
		String address=registrationBean.getAddress();
		String city=registrationBean.getCity();
		String state =registrationBean.getState();
		String country =registrationBean.getCountry();	
		String pincode=registrationBean.getPincode();  	
		String phone=registrationBean.getPhone();  	
		String email=registrationBean.getEmail();
		String qualification=registrationBean.getQualification();
		int percentage=registrationBean.getPercentage();
		String collegeName=registrationBean.getCollegeName();
		String addQualification=registrationBean.getAddQualification();

		System.out.println("Inside RegistrationDao class");

		MySqlHelper helper=new MySqlHelper();
		MySqlHelper helper1=new MySqlHelper();
		
		sucess=helper.executeUpdate("insert into registration values ('"+loginName+"',+'"+firstName+"','"+middleName+"','"+lastName+"','"+birthDate +"','"+gender+"','"+address+"','"+city+"','"+state+"','"+country+"','"+pincode+"','"+phone+"','"+email+"','"+qualification+"','"+percentage+"','"+collegeName+"','"+addQualification+"')");

		sucess=helper1.executeUpdate("insert into login values ('"+loginName+"',+'"+password+"')");

		System.out.println("Data inserted sucessfully in database");

		return sucess;
	}
}
