package com.vcube;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	 public String selectStudent(LoginModel k) throws SQLException {
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
	            PreparedStatement s = connection.prepareStatement("select stdid,password from user where stdid=? and password=?"
	            		+ "");
	            
	            s.setString(1, k.getStdid());
	           s.setString(2, k.getPassword());

	            ResultSet rs = s.executeQuery();
				while (rs.next()) {
	             status="True";
	             System.out.println(" matched----------------");
				}

			
			
			return status;
		}

	    }


