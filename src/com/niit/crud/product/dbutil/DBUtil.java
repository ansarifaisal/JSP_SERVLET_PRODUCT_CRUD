package com.niit.crud.product.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	//Connection Configuration
	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:tcp://localhost/~/testDemo";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";
	
	//Connection object creation
	private static Connection connection = null;
	
	public static Connection getConnection(){
		//Connection object initialization
		if(connection == null){
			try {
				Class.forName(DRIVER);
				System.out.println("Driver Loaded!");
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection Established!");
			} catch (ClassNotFoundException e) {
				System.out.println("Class Not Found: "+e.getMessage());
			} catch (SQLException e) {
				System.out.println("SQL Error: "+e.getMessage());
			}
		}
		
		return connection;
	}
}
