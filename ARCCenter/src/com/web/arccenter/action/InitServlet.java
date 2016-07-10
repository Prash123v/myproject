package com.web.arccenter.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import com.web.arccenter.databaseconnection.MySqlHelper;


public class InitServlet extends HttpServlet
{
	MySqlHelper setpro;

	public void init(ServletConfig sc)
	{
		ServletContext ctx = sc.getServletContext();
		InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config"));
		Properties props = new Properties();
		
		try
		{
			props.load(fis);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		setpro = new MySqlHelper();
		setpro.setProperties(props);
		System.out.println("InitServlet called");
	}
}
