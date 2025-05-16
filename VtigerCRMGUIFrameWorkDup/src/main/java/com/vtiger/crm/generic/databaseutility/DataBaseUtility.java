package com.vtiger.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection connect;
	String url="Jdbc:mysql://49.249.28.218:3333/ninza_hrm";
	String username="root";
	String password="root";
	
	public void getdBConnection(String url, String username, String password) throws Exception{
	try {
	Driver d= new Driver();
	DriverManager.registerDriver(d);
	connect=DriverManager.getConnection(url, username, password);
	}
	catch (Exception e)
	{
		System.out.println("Handled Exception");
	}
}
	
	public void closedBConnection() throws Exception 
	{
		try {
		connect.close();
		}
		catch(Exception e) {
			
		}
	}
	public ResultSet executeSelectQuery(String query) throws Exception
	{ 
		ResultSet result=null;
		try {
		Statement state=connect.createStatement();
		result =state.executeQuery(query);
		}
		catch(Exception e) {
			System.out.println("Query Exception is Handled");
		}
		return result;
	}
	
	public int executeNonSelecetQuery(String query) throws Exception
	{
		int res=0;
		try {
		Statement state=connect.createStatement();
		state.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return res;
	}
	

	
	
}
