package com.vcube;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.*;
public class RegisterDao {
//	private String jdbcURL = "jdbc:mysql://localhost:3306/db1";
//    private String jdbcUsername = "root"; // Change as per your DB credentials
//    private String jdbcPassword = "root"; // Change as per your DB credentials
//
//    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, lname,id, password) VALUES (?, ?,?, ?)";

    public String insertUser(RegisterModel k) throws SQLException {
        String status = "false";
       
            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Connection connection = null;
			try {
				connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/db1", "root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user(fname, lname,stdid, password) VALUES (?, ?,?, ?)");
           
            statement.setString(1, k.getFname());
            statement.setString(2, k.getLname());
            statement.setString(3, k.getId());
            statement.setString(4, k.getPassword());

            int n= statement.executeUpdate() ;
           if(n>0) {
        	   System.out.print("insert success");
        	   status="true";
           }
       
        
        return status;
    }
}
